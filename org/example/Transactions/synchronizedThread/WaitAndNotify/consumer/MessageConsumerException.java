package org.example.Transactions.synchronizedThread.WaitAndNotify.consumer;

public class MessageConsumerException extends RuntimeException{
    public MessageConsumerException(){

    }
    public MessageConsumerException(String message) {
        super(message);
    }

    public MessageConsumerException(Throwable cause) {
        super(cause);
    }

    public MessageConsumerException(String message, Throwable cause) {
        super(message, cause);
    }
}
