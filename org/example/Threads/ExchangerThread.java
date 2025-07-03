package org.example.Threads;

import java.util.concurrent.Exchanger;

public class ExchangerThread {
    public static void main(String[] args) { //Чтобы передавать данные между потоками
        Exchanger<String> exchanger = new Exchanger<>();

        new Mike(exchanger);
        new Anket(exchanger);
    }

    static class Mike extends Thread{
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Привет мое имя Mike");
                sleep(3000);
                exchanger.exchange("Мне 17 лет");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Anket extends Thread{
        Exchanger<String> exchanger;

        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                String info1 = exchanger.exchange(null);
                System.out.println(info1);
                String info2 = exchanger.exchange(null);
                System.out.println(info2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
