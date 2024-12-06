package org.example.ProdvinytaiJava.Multithreading.ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListThread {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("Zaur");
        arrayList.add("Oleg");
        arrayList.add("Sergey");
        arrayList.add("Ivan");
        arrayList.add("Igor");

        Runnable runnable = () -> {
            Iterator<String> iterator = arrayList.iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next());
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arrayList.remove(4);
            arrayList.add("Elena");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(arrayList);
    }
}
