package org.example.Threads;

public class VolatileThread {

    volatile static int i = 0;//Чтобы менялось значение во всех потоках и записывалась в память
    //используют тогда когда есть поток который читает и есть который меняет значение

    public static void main(String[] args) {
        new MyVolatileReadThread().start();
        new MyVolatileWriteThread().start();
    }

    static class MyVolatileWriteThread extends Thread{
        @Override
        public void run() {
            while (i < 5){
                System.out.println("Инкремент i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class MyVolatileReadThread extends Thread{
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5){
                if(localVar != i){
                    System.out.println("Новое значение i " +  i);
                    localVar = i;
                }
            }
        }
    }
}
