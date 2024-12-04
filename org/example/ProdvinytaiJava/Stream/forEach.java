package org.example.ProdvinytaiJava.Stream;

import java.util.Arrays;

public class forEach {
    public static void main(String[] args) {
        int[] array = {5,9,3,8,1};
        Arrays.stream(array).forEach(element -> System.out.println(element));
        System.out.println();

        Arrays.stream(array).forEach(System.out::println);//ТОЖЕ САМОЕ ЧТО ВЫШЕ
        System.out.println();

        Arrays.stream(array).forEach(Utils::myMethod);

        System.out.println();
        Arrays.stream(array).forEach(element -> {
            element *= 2;
            System.out.println(element);
        });
    }
}

class Utils{
    public static void myMethod(int i){
        i += 5;
        System.out.println(i);
    }
}