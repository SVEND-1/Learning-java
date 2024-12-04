package org.example.JavaLite.Interfaces;

public class Animal implements Info{
    public Animal(int id){
        this.id = id;
    }
    public int id;
    public void sleep(){
        System.out.println(" Спит");
    }
    public void showInfo(){
        System.out.println("id is " + this.id);
    }
}

