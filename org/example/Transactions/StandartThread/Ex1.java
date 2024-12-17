package org.example.Transactions.StandartThread;

public class Ex1 {
    public static void main(String[] args) {
        final Thread thread = new MyThread();
        thread.start();

        final Runnable task = () -> System.out.println("Лямда раннебл");
        final Thread thread1 = new Thread(task);
        thread1.start();


        new Thread(() -> System.out.println("Лямда поток")).start();
    }

    private static final class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println(currentThread().getName());
        }
    }
}
