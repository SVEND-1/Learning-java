package org.example.ProdvinytaiJava.Multithreading.Threads;

public class Ex7 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("метод майн старт");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join(1500);//МОЖНО ПОСТАВИТЬ ВРЕМЯ ЧЕРЕЗ КАКОЕ МАЙН ПРОДОЛЖИТ РАБОТУ А НЕ КОГДА ЗАКОНЧИТ ДРУГОЙ ПОТОК
        System.out.println(thread.getState());
        System.out.println("метод майт конец");
    }
}

class Worker implements Runnable{

    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Работа закончина");
    }
}