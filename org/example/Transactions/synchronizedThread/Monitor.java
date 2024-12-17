package org.example.Transactions.synchronizedThread;

import java.util.function.IntConsumer;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class Monitor {
    private static int firstCount = 0;
    private static int secondCount = 0;
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();//ВМЕСТО ЭТОГО МОЖНО СДЕЛАТЬ КАК НИЖЕ
    public static void main(String[] args) throws InterruptedException {
        final Counter firstCount = new Counter();
        final Counter secondCount = new Counter();

        Thread thread1 = createIncrementingCounterThread(500,i -> firstCount.increment());
        Thread thread2 = createIncrementingCounterThread(500,i -> firstCount.increment());

        Thread thread3 = createIncrementingCounterThread(600,i -> secondCount.increment());
        Thread thread4 = createIncrementingCounterThread(600,i -> secondCount.increment());

        startThreads(thread1,thread2,thread3,thread4);

        waitUntilAreCompleted(thread1,thread2,thread3,thread4);

        System.out.println(firstCount.counter);
        System.out.println(secondCount.counter);
    }

    private static final class Counter{
        private int counter;
        public void increment(){
            synchronized (this) {
                this.counter++;
            }
        }
    }

    private static Thread createIncrementingCounterThread(final int Increment, final IntConsumer intConsumer) {
        return new Thread(() -> {
            range(0, Increment).forEach(intConsumer);
        });
    }

    private static void startThreads(final Thread... threads){
        stream(threads).forEach(Thread::start);
    }
    private static void waitUntilAreCompleted(final Thread... threads){
        stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    //ЕСЛИ РАБОТА С РАЗНЫМИ ПЕРЕМЕННЫМИ И ТУТ НЕ НАДО СИНХРОНАЙЗ
    private static  void IncrementingFirstCounter(){
        synchronized (monitor1) {
            firstCount++;
        }
    }
    private static  void IncrementingSecondCounter(){
        synchronized (monitor2) {
            secondCount++;
        }
    }
}
