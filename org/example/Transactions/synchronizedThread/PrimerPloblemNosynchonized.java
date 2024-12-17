package org.example.Transactions.synchronizedThread;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class PrimerPloblemNosynchonized {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = createIncrementingCounterThread(500);
        Thread thread2 = createIncrementingCounterThread(600);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);//ВСЕГДА РАНДОМНО
    }

    private static Thread createIncrementingCounterThread(final int Increment){
        return new Thread(() ->{
            range(0,Increment).forEach(i -> count++);
        });
    }
}
