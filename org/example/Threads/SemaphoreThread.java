package org.example.Threads;

import java.util.concurrent.Semaphore;

public class SemaphoreThread {
    public static void main(String[] args) {//Очередь у потоков
        Semaphore table = new Semaphore(2);

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();

        person1.table = table;
        person2.table = table;
        person3.table = table;
        person4.table = table;
        person5.table = table;
        person6.table = table;
        person7.table = table;

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();
    }
}

class Person extends Thread{
    Semaphore table;

    @Override
    public void run() {
        try {
            table.acquire();//Сделать запрос на стол
            System.out.println(this.getName() + " ест за столом");
            Thread.sleep(1000);
            System.out.println(this.getName() + " поел и встал из стола");
            table.release();//Освободить
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
