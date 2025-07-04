package org.example.ProdvinytaiJava.AllCollection.SynchronizedCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionEx1 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for(int i = 0; i < 5;i++){
            source.add(i);
        }
        List<Integer> sinchList = Collections.synchronizedList(new ArrayList<>());

        Runnable runnable = () -> {sinchList.addAll(source);};

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(sinchList);
    }
}
