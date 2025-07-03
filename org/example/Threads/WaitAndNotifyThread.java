package org.example.Threads;

public class WaitAndNotifyThread {
    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        synchronized (waitThread){//Надо всегда в synchronized
            waitThread.wait();//ждет пока выполниться поток
        }
        System.out.println(waitThread.total);
    }

    static class WaitThread extends Thread{
        int total;
        @Override
        public void run() {
            synchronized (this){
                for(int i = 0; i < 5;i++){
                    total += i;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //Надо всегда в synchronized
                notify();//оповещает что поток выполнился
            }
        }
    }
}
