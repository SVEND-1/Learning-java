package org.example.Transactions.synchronizedThread.WaitAndNotify.Producer;

import org.example.Transactions.synchronizedThread.WaitAndNotify.Model.Message;
import org.example.Transactions.synchronizedThread.WaitAndNotify.broker.MessageBroker;

public class MessageProducerTask implements Runnable {
    private final MessageBroker messageBroker;
    private final MessageFactory messageFactory;
    private final int maximalAmountMessageToProducer;
    private final String name;

    public MessageProducerTask(MessageBroker messageBroker, MessageFactory messageFactory, int maximalAmountMessageToProducer, String name) {
        this.messageBroker = messageBroker;
        this.messageFactory = messageFactory;
        this.maximalAmountMessageToProducer = maximalAmountMessageToProducer;
        this.name = name;
    }

    public int getMaximalAmountMessageToProducer() {
        return maximalAmountMessageToProducer;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {//ПОКА ПОТОК НЕ ПРЕРВАН
            try {
                Thread.sleep(1000);
                final Message producedMessage = this.messageFactory.Create();
                this.messageBroker.produce(producedMessage,this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
