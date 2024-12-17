package org.example.Transactions.synchronizedThread.WaitAndNotify.Producer;

import org.example.Transactions.synchronizedThread.WaitAndNotify.Model.Message;

public final class MessageFactory {
    private static final int INITIAL_NEXT_MESSAGE_INDEX = 1;
    private int nextMessageIndex;

    public MessageFactory() {
        this.nextMessageIndex = INITIAL_NEXT_MESSAGE_INDEX;
    }

    public Message Create() {
        return new Message("Message: " + this.findAndIncrementNextMessageIndex());
    }

    private synchronized int findAndIncrementNextMessageIndex(){
        return this.nextMessageIndex++;
    }
}
