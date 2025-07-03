package org.example.Threads;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryThread {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {//Типо сразу будет выдавать поток с настройками
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        threadFactory.newThread(new MyRunThread()).start();
    }

    static class MyRunThread implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
