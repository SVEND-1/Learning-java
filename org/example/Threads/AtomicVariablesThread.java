package org.example.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesThread {

    static AtomicInteger i = new AtomicInteger(0);//Чтобы всегда выполнялось нормально увеличение или уменьшение

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000;i++){
            new MyAtomicThread().start();
        }
        Thread.sleep(2000);
        System.out.println(i.get());
    }

    static class MyAtomicThread extends Thread{
        @Override
        public void run() {
            i.incrementAndGet();//Увеличить на 1
        }
    }

}
