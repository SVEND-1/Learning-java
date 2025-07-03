package org.example.Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizationArrayThread {

    public static void main(String[] args) {//Даже то что это синхронайз лист все равно надо синхронизировать методы
        NameList nameList = new NameList();//Даже не особо нужно синзронайз листы
        nameList.add("Первый");//Использовать синхронайз лист тогда когда надо вернуть лист и то не очень прям нужно
        class MyArrayThread extends Thread{
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());;
            }
        }
        new MyArrayThread().start();
        new MyArrayThread().start();
    }

    static class NameList{
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name){
            synchronized (list) {
                list.add(name);
            }
        }

        public String removeFirst(){
            synchronized (list) {
                if (list.size() > 0) {
                    return (String) list.remove(0);
                }
                return null;
            }
        }
    }
}
