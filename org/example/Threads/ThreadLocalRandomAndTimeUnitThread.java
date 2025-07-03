package org.example.Threads;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomAndTimeUnitThread {
    public static void main(String[] args) {
//        System.out.println(Math.random());//В многопоточности простой рандом нельзя делать
        System.out.println(ThreadLocalRandom.current().nextInt());//Вот такой рандом надо использовать

        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(14));//14 минут
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
