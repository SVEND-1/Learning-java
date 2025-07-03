package org.example.Threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockThread {
    public static void main(String[] args) throws InterruptedException {//java Visualvm для того чтобы проверить есть ли дедлок или нету
        //Deadlock это когда два потока работают с ресурсами и может произойти так что
        //будет бесконечно выполнять программа и все зависнет
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        MyDeadlockThread1 myDeadlockThread1 = new MyDeadlockThread1();
        MyDeadlockThread2 myDeadlockThread2 = new MyDeadlockThread2();

        myDeadlockThread1.resourceA = resourceA;
        myDeadlockThread2.resourceB = resourceB;

        myDeadlockThread1.start();
        myDeadlockThread2.start();

        Thread.sleep(1000);

        //Проверка есть ли дедлок
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if(deadlockedThreads != null){
            System.out.println("Дедлок есть");
            ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
            for (ThreadInfo info : threadInfo){
                System.out.println(info);
            }
        }
    }
}

class MyDeadlockThread1 extends Thread{
    ResourceA resourceA;

    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class MyDeadlockThread2 extends Thread{
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA{
    ResourceB resourceB;
    public synchronized int getI(){
        return resourceB.returnI();
    }
    public synchronized int returnI(){
        return 1;
    }
}

class ResourceB{
    ResourceA resourceA;
    public synchronized int getI(){
        return resourceA.returnI();
    }
    public synchronized int returnI(){
        return 2;
    }
}

//Если написать так то Deadlock не произойдет
//class ResourceA {
//    ResourceB resourceB;
//
//    public int getI() {
//        synchronized(ResourceA.class) {  // Блокируем сначала ResourceA
//            synchronized(ResourceB.class) {  // Потом ResourceB
//                return resourceB.returnI();
//            }
//        }
//    }
//}
//
//class ResourceB {
//    ResourceA resourceA;
//
//    public int getI() {
//        synchronized(ResourceA.class) {  // Тот же порядок!
//            synchronized(ResourceB.class) {
//                return resourceA.returnI();
//            }
//        }
//    }
//}