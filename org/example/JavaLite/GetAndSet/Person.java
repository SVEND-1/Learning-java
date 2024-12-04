package org.example.JavaLite.GetAndSet;

public class Person {
    private String name;
    private int age;
    Person(String name , int age){
        this.name = name;
        this.age = age;
    }
    Person(){
        this.name = name;
        this.age = age;
    }
    public void setName(String userName){
        name = userName;
    }
    public void setAge(int userAge){
        age = userAge;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

}
