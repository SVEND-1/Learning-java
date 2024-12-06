package org.example.ProdvinytaiJava.Multithreading.Threads;

public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 5;i > 0; i--){
            System.out.println(i);
            Thread.sleep(1000);//НА СКОЛЬКО СЕКУНД ОСТАНОВИТСЯ ПОТОК
        }
        System.out.println("Поехали");
    }
}
