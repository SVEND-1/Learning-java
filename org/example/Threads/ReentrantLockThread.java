package org.example.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread {
    public static void main(String[] args) throws Exception {
        ResourceReentrantLock resource = new ResourceReentrantLock();
        resource.i = 5;

        MyReentrantLockThread myThread = new MyReentrantLockThread();
        myThread.setName("owner");
        MyReentrantLockThread myThread1 = new MyReentrantLockThread();

        myThread.resource = resource;
        myThread1.resource = resource;

        myThread.start();
        myThread1.start();

        myThread.join();
        myThread1.join();

        System.out.println(resource.i);
    }

    static class MyReentrantLockThread extends Thread {
        ResourceReentrantLock resource;
        @Override
        public void run() {
            resource.changeI();
            resource.changeJ();
        }
    }
}

class ResourceReentrantLock {
    int i;
    int j;
    Lock lock = new ReentrantLock();

    void changeI() {//Тоже самое что синхронизация всегда будет изменяться правильно
        lock.lock();
        int i = this.i;
        if (Thread.currentThread().getName().equals("owner")) {
            Thread.yield();
        }
        i++;
        this.i = i;
      //  lock.unlock();//не обезательно тут unlock можно хоть в каком методе другом
    }

    void changeJ() {
        int j = this.j;
        if (Thread.currentThread().getName().equals("owner")) {
            Thread.yield();
        }
        j++;
        this.j = j;
        lock.unlock();
    }
}