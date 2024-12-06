package org.example.ProdvinytaiJava.Multithreading.Threads;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет");
            }
        }).start();
        new Thread(() -> System.out.println("Лямда поток")).start();
    }
}
