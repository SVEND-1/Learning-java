package org.example.Threads;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueThread {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();//С обычной очередью в потоках будет ошибка
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());//Тоже самое что remove,засыпает пока не будет add использовано
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                queue.add("this is string");
            }
        }.start();
    }
}
