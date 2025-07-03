package org.example.Threads;



public class CreateThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        try {
            thread.join();//Подождать пока закончиться выполнение
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main");

        Thread thread1 = new Thread(() -> {
            System.out.println("Поток работает: " + Thread.currentThread().getName());
        });
        thread1.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Новый поток");
    }
}

class  MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
        System.out.println("Новый Runnable");
    }
}