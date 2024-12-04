package org.example.JavaLite.Interfaces;

public class Person implements Info{
    public Person(String name){
        this.name = name;
    }
    public String name;
    public void sayHello(){
        System.out.println("Hello");
    }
    public void showInfo(){
        System.out.println("name is " + this.name);
    }
}
