package org.example.ProdvinytaiJava.Multithreading.Threads;

public class Ex2 extends Thread{
    public void run(){
        for(int i = 1;i < 1001;i++){
            System.out.println(i + "   1");
        }
    }
    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        ex2.start();

         MyThread myThread = new MyThread();
         MyThread2 myThread2 = new MyThread2();
         myThread.start();
         myThread2.start();
    }
}

class MyThread extends Thread{
    public void run(){
        for(int i = 1;i < 1001;i++){
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread{
    public void run(){
        for(int i = 1000;i > 0;i--){
            System.out.println(i);
        }
    }
}