package org.example.ProdvinytaiJava.Multithreading.Threads;

public class Ex6 extends Thread{
    public void run(){
        for(int i = 1;i <= 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Ex6 thread2 = new Ex6();
        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();//ПОТОК В КОТОРОМ ВЫЗЫВАЮТСЯ ЭТИ ПОТОКИ ЖДЕТ ПОКА ОНИ ПОЛНОСТЬЮ ВЫПОЛНЯТЬСЯ

        System.out.println("Конец");
    }
}

class MyRunnable1 implements Runnable{
    public void run(){
        for(int i = 1;i <= 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}