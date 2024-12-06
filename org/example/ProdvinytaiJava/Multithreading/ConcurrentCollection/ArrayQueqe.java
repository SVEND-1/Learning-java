package org.example.ProdvinytaiJava.Multithreading.ConcurrentCollection;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayQueqe
{
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);//УКАЗЫВАТЬ СКОЛЬКО БУДЕТ ОЧЕРЕДЬ
        new Thread(() -> {
            int i = 0;
            while (true){
                try {
                    queue.put(i++);
                    System.out.println("продючес добавил: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                try {
                    Integer j = queue.take();
                    System.out.println("консюмер взял " + j);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
