package org.example.Threads.Practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GameSessionThread extends Thread{
    private User currentUser;
    private UserDB userDB;
    private volatile boolean running = true;
    private Lock lock;
    public GameSessionThread(User currentUser){
        this.currentUser = currentUser;
        userDB = DataBaseConnection.getInstance().getUserDB();
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        while (running) {
            lock.lock();
            try {
                currentUser.setBalance(currentUser.getBalance() + currentUser.getIncome());
                userDB.update(currentUser);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void stopRunning() {
        running = false;
        this.interrupt(); // Прерываем поток, если он спит или ожидает
    }
}
