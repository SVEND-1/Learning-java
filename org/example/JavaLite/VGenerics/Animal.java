package org.example.JavaLite.VGenerics;

public class Animal {
    private int id;
    public Animal(){

    }
    public Animal(int id){
        this.id = id;
    }
    public void eat(){
        System.out.println("eat");
    }
    public String toString(){
        return String.valueOf(id);
    }
}
