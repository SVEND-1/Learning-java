package org.example.JavaLite;

public class Konstructor {
    public static void main(String[] args) {
        Human human = new Human("боб",6);
    }
}

class Human{//КОНСТРУКТОРЫ ТИПО ВМЕСТО СЕТНАЙМ НАПРИМЕР
    private String name;
    private int age;
    public Human(){
        this.name = "Имя";
        this.age = 0;
    }
    public Human(String name,int age){//КОНСТРУКТОР и это что то типо метода
        this.name = name;
        this.age = age;
        System.out.println("3");
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}