package org.example.Transactions.StandartThread;



import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Ex3 {
    private static final String MESSAGE_REQUEST_WAS_SENT = "\nRequest was sent.";
    private static final int DURATION_IN_SECONDS_DELIVERING_RESPONSE = 1;
    private static final String MESSAGE_RESPONSE_WAS_RECEIVED = "Response was received.";
    private static final String MESSAGE_SERVER_WAS_STOPPED = "Server was stopped";

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()){
                try {
                    doRequest();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();


        final Thread stoppingThread =  new Thread(() -> {
            if(isServerShouldBeOffed()){
                thread.interrupt();
                stopServer();
            }
        });
        Thread.sleep(5000);
        stoppingThread.start();
    }

    private static void doRequest() throws InterruptedException {
        System.out.println(MESSAGE_REQUEST_WAS_SENT);
        SECONDS.sleep(DURATION_IN_SECONDS_DELIVERING_RESPONSE);
        System.out.println(MESSAGE_RESPONSE_WAS_RECEIVED);
    }

    private static boolean isServerShouldBeOffed(){
        return true;
    }

    private static void stopServer(){
        System.out.println(MESSAGE_SERVER_WAS_STOPPED);
    }
}
