package org.example.Threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceThread {
    public static void main(String[] args) {//Чтобы выполнял не сразу а через время
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyScheduledExecutorServiceThread(),3, TimeUnit.SECONDS);//запустить через 3 секунды
        scheduledExecutorService.shutdown();
       // scheduledExecutorService.shutdownNow();//Принудительно остановить даже если не закончились потоки
    }

    static class MyScheduledExecutorServiceThread extends Thread{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
