package org.example.JavaLite.Nasledovanya;

public class Dog extends Animal{

    public void bark(){
        System.out.println("I am barking");
    }

    public void eat(){
        System.out.println("СОБАКА");//МОЖНО ПЕРЕОПРЕДЕЛИТЬ МЕТОД ОТ НАСЛЕДОВАТЕЛЯ
    }

    public void showName(){
        System.out.println(name);
    }
}
