package org.example.Transactions.StandartThread;

public class DemonStream {
    public static void main(String[] args) {//НЕ ИСПОЛЬЗОВАТЬ С БАЗАМИ ДАННЫМИ ИЛИ С ФАЙЛАМИ
        /*
        System.out.println(Thread.currentThread().isDaemon());//Тру демон false не демон
        final Thread thread = new Thread(new Task());
        thread.setDaemon(true);//СДЕЛАЛИ ДЕМОНОМ ЗАКОНЧИТЬСЯ КОГДА ЗАКОНЧИТЬСЯ main ПОТОК ЕСЛИ В НЕМ СОЗДАТЬ ПОТОК ТО ТОТ ТОЖЕ БУДЕТ ДЕМОНОМ

        thread.start();

        System.out.println("майн закончил работу");

         */

        final Thread first = new Thread(() -> {
            printThreadNameAndDaemonStatus(Thread.currentThread());
            final Thread second = new Thread(() ->{
                printThreadNameAndDaemonStatus(Thread.currentThread());
            });
            second.start();
            try {
                second.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.setDaemon(true);
        first.start();

        try {
            first.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printThreadNameAndDaemonStatus(final Thread thread){
        System.out.println(thread.getName() + "  " + thread.isDaemon() + " \n");
    }

    private static final class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().isDaemon());

            while (true){
                System.out.println("поток демон работает");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
