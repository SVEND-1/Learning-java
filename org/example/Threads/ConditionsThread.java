package org.example.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionsThread {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();//типо wait and notify
    static int account = 0;

    public static void main(String[] args) {
        new AccountMinus().start();
        new AccountPlus().start();
    }

    static class AccountPlus extends Thread{
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread{
        @Override
        public void run() {
            if(account < 10) {
                try {
                    lock.lock();
                    condition.await();//Ждем пока будет не меньше 10
                    lock.unlock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            account -= 10;
        }
    }
}
