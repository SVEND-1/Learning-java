package org.example.ProdvinytaiJava.Multithreading.ConcurrentCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapConc {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1, "Zaur");
        hashMap.put(2, "Oleg");
        hashMap.put(3, "Sergey");
        hashMap.put(4, "Ivan");
        hashMap.put(5, "Igor");

        Runnable runnable = () -> {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + ". " + hashMap.get(i));
            }
        };
        Runnable runnable2 = () ->{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hashMap.put(6,"Elena");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(hashMap);
    }
}
