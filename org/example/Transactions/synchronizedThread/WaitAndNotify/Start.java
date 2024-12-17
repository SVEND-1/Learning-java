package org.example.Transactions.synchronizedThread.WaitAndNotify;

import org.example.Transactions.synchronizedThread.WaitAndNotify.Producer.MessageFactory;
import org.example.Transactions.synchronizedThread.WaitAndNotify.Producer.MessageProducerTask;
import org.example.Transactions.synchronizedThread.WaitAndNotify.broker.MessageBroker;
import org.example.Transactions.synchronizedThread.WaitAndNotify.consumer.MessageConsumerTask;

import static java.util.Arrays.stream;


public class Start {
    public static void main(String[] args) {
        final int brokerMaxMessage = 15;
        final MessageBroker messageBroker = new MessageBroker(brokerMaxMessage);

        final MessageFactory messageFactory = new MessageFactory();

        final Thread firstProducingThread = new Thread(new MessageProducerTask(messageBroker,messageFactory,brokerMaxMessage," 1 "));
        final Thread secondProducingThread = new Thread(new MessageProducerTask(messageBroker,messageFactory,10, " 2 "));
        final Thread thirdProducingThread = new Thread(new MessageProducerTask(messageBroker,messageFactory,5," 3 "));

        final Thread firstConsumerThread = new Thread(new MessageConsumerTask(messageBroker,0,"1 "));
        final Thread secondConsumerThread = new Thread(new MessageConsumerTask(messageBroker, 6,"2"));
        final Thread thirdConsumerThread = new Thread(new MessageConsumerTask(messageBroker,11,"3"));

        startThreads(firstProducingThread,secondProducingThread,thirdProducingThread,
                firstConsumerThread,secondConsumerThread,thirdConsumerThread);
    }

    private static void startThreads(final Thread... threads){
        stream(threads).forEach(Thread :: start);
    }
}
