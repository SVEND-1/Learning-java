package org.example.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockThread {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new MyTryLockThread1().start();
        new MyTryLockThread2().start();
    }

    static class MyTryLockThread1 extends Thread{
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " начал работать");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " закончил работать");
            lock.unlock();
        }
    }

    static class MyTryLockThread2 extends Thread{
        @Override
        public void run() {
            System.out.println(getName() + " начал работать");
            while (true) {
                if (lock.tryLock()) {//Проверяет освобожден ли ресурс можно работать или нет
                    System.out.println(getName() + " работает");
                    break;
                }
                else{
                    System.out.println(getName() + " ждет");
                }
            }
            System.out.println(getName() + " закончил работу");
        }
    }
}
