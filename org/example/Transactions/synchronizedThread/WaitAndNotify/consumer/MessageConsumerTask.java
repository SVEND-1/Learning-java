package org.example.Transactions.synchronizedThread.WaitAndNotify.consumer;

import org.example.Transactions.synchronizedThread.WaitAndNotify.Model.Message;
import org.example.Transactions.synchronizedThread.WaitAndNotify.broker.MessageBroker;

import java.util.Optional;

public class MessageConsumerTask implements Runnable{
    private final MessageBroker messageBroker;
    private final int minimalAmountMessageToStart;
    private final String name;

    public MessageConsumerTask(MessageBroker messageBroker, int minimalAmountMessageToStart, String name) {
        this.messageBroker = messageBroker;
        this.minimalAmountMessageToStart = minimalAmountMessageToStart;
        this.name = name;
    }

    public int getMinimalAmountMessageToStart() {
        return minimalAmountMessageToStart;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                final Optional<Message> optionalMessage = this.messageBroker.consume(this);
                optionalMessage.orElseThrow(MessageConsumerException::new);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
