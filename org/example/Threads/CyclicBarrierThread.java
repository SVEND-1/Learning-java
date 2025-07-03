package org.example.Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new RunThread());//RunThread начнет работу когда 3 других будут готовы
        //Ждет когда будет 3 потока готовы к старту
        //Когда готов поток это поймет cyclicBarrier когда найдет barrier.await
        new Sportsmen(cyclicBarrier);
        new Sportsmen(cyclicBarrier);
        new Sportsmen(cyclicBarrier);
    }

    static class RunThread extends Thread{
        CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            System.out.println("Run is began");
        }
    }

    static class Sportsmen extends Thread{
        CyclicBarrier barrier;

        public Sportsmen(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

