package org.example.Transactions.StandartThread;


import java.util.concurrent.ThreadFactory;

public class ThreadExep {
    public static void main(String[] args) {

        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (thread,exception) -> System.out.println("Сообщение для переопределение ошибки");//СПЕРВА ПОТОК ПОСЛЕ ИСКЛЮЧЕНИЕ

        final Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);//ПЕРЕОПРЕДЕЛЕНИЕ ОШИБКИ
        thread.setDaemon(true);
        thread.start();

        final Thread thread2 = new Thread(new Task());
        thread2.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        thread2.setDaemon(true);
        thread2.start();

        final ThreadFactory threadFactory = new Factory(uncaughtExceptionHandler);

        final Thread thread3 = threadFactory.newThread(new Task());
        thread3.start();

        final Thread thread4 = threadFactory.newThread(new Task());
        thread4.start();

    }

    private static final class Task implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException("Сообщение для переопределение ошибки");
        }
    }

    private static final class Factory implements ThreadFactory {
        private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

        public Factory(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        }

        @Override
        public Thread newThread(Runnable r) {//ЧТОБЫ ВСЕ ТРЕДЫ ШЛИ С 1 и ТЕМ ЖЕ НАСТРОЙКАМИ
            Thread newthread = new Thread(r);
            uncaughtExceptionHandler = (thread,exception) -> System.out.println("Сообщение для переопределение ошибки");
            newthread.setUncaughtExceptionHandler(uncaughtExceptionHandler);//ПЕРЕОПРЕДЕЛЕНИЕ ОШИБКИ
            newthread.setDaemon(true);
            return newthread;
        }
    }
}
