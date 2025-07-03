package org.example.Threads;


public class SynchronizationThread {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(5);

        Resource.j = 5;

        MySThread mySThread = new MySThread();
        MySThread mySThread1 = new MySThread();

        mySThread.setResource(resource);
        mySThread1.setResource(resource);


        mySThread.start();
        mySThread1.start();

        mySThread.join();
        mySThread1.join();

        System.out.println(resource.getI());
        System.out.println(Resource.j);
    }
}

class MySThread extends Thread{
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.changeI();
        }
        for (int i = 0; i < 1000; i++) {
            resource.changeJ();
        }
    }
}

class Resource{
    private int i ;
    static int j;
    public int getI() {
        return i;
    }

    public synchronized void setI(int i) {
        this.i = i;
    }

    public synchronized static void changeJ(){
        int j = Resource.j;
        j++;
        Resource.j = j;
    }

    public void minusJ(){
        synchronized (Resource.class){
            int i = this.i;
            i--;
            this.i = i;
        }
    }

    public synchronized void changeI(){
        int i = this.i;
        i++;
        this.i = i;
    }

    public void minusI(){
        synchronized (this){
            int i = this.i;
            i--;
            this.i = i;
        }
    }
}