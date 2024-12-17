package org.example.Transactions.synchronizedThread.WaitAndNotify.broker;

import org.example.Transactions.StandartThread.ThreadExep;
import org.example.Transactions.synchronizedThread.WaitAndNotify.Model.Message;
import org.example.Transactions.synchronizedThread.WaitAndNotify.Producer.MessageProducerTask;
import org.example.Transactions.synchronizedThread.WaitAndNotify.consumer.MessageConsumerTask;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public final class MessageBroker {
    private final Queue<Message> messagesToBeConsumed;
    private final int MAX_MESSAGE;

    public MessageBroker(int MAX_MESSAGE) {
        this.messagesToBeConsumed = new ArrayDeque<>(MAX_MESSAGE);
        this.MAX_MESSAGE = MAX_MESSAGE;
    }

    public synchronized void produce(final Message message,final MessageProducerTask messageProducerTask) {
        try {
            while (this.isShouldProducer(messageProducerTask)) {
                super.wait();//ОТДАЕТ МОНИТОР
            }
            this.messagesToBeConsumed.add(message);
            System.out.println("Сообщение " + message + " дошло до продюсера " + messageProducerTask.getName());
            super.notifyAll();//ГОТОВИТ ЧТО СДЕЛАЛ ЗАДАЧУ И ДАЕТ ВОЗМОЖНОСТЬ ПОДКЛЮЧИТСЯ К МОНИТОРУ
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public synchronized Optional<Message> consume(final MessageConsumerTask consumerTask) {
        try {
            while (!isShouldConsume(consumerTask)) {//ПРОВЕРКА ПУСТА ЛИ ОЧЕРЕДЬ
                super.wait();//МОЖНО ПИСАТЬ КОЛИЧЕСТВО МИЛЛИСЕКУНД КАК join() СКОЛЬКО БУДЕТ ЖДАТЬ ПРЕЖДЕ ЧЕМ ПРОДОЛЖИТЬ ТУТ ТИПО АВТОМАТИЧЕСКИ БУДЕТ notify()
            }
            final Message consumerMessage = this.messagesToBeConsumed.poll();
            System.out.println("Сообщение " + consumerMessage + " дошло до сонсумера " + consumerTask.getName());
            super.notifyAll();//ЕСЛИ БОЛЬШЕ 2 ПОТОКОВ ВЫЗЫВАТь ALL
            return Optional.ofNullable(consumerMessage);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }

    private boolean isShouldConsume(final MessageConsumerTask consumerTask){
        return this.messagesToBeConsumed.size() <= this.MAX_MESSAGE && this.messagesToBeConsumed.size() >= consumerTask.getMinimalAmountMessageToStart();
    }
    private boolean isShouldProducer(final MessageProducerTask producerTask){
        return this.messagesToBeConsumed.isEmpty() && this.messagesToBeConsumed.size() < producerTask.getMaximalAmountMessageToProducer();
    }
}

