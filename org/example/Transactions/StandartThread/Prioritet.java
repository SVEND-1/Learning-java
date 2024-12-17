package org.example.Transactions.StandartThread;

public class Prioritet {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority() + " " + Thread.currentThread().getName());

        final Runnable task = () -> System.out.println(Thread.currentThread().getPriority() + " " + Thread.currentThread().getName());//ТУТ ТОЖЕ БУДЕТ 10 ПОТОМУ ЧТО СОЗДАЛИ В ПОТОКЕ У КОТОРОГО ПРИОРИТЕТ 10

        Thread thread = new Thread(task);
        thread.start();
    }
}
