package org.example.Threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread {
    public static void main(String[] args) throws InterruptedException {//чтобы потоки считали что то и CountDownLatch потом хранит значение
        CountDownLatch countDownLatch = new CountDownLatch(3);//сколько потоков должно завершиться
//        countDownLatch.countDown();//когда работа с одним потоком закончилась с делает в этом примере 3 - 1
//        countDownLatch.await();//ждет пока счетчик будет равен 0
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await();//тут не работает дальше ждет пока все сделается пока счетчик будет 0
        System.out.println("Все работы завершены");
    }
}

class Work extends Thread{
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Закончил свою работу");
        countDownLatch.countDown();
    }
}