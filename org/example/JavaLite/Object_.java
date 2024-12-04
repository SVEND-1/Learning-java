package org.example.JavaLite;

public class Object_ {
    public static void main(String[] args) {
        ClassObject h1 = new ClassObject("Bob",4);
        System.out.println(h1);
    }
}

class ClassObject{
    private String name;
    private int age;
    public ClassObject(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){//ЭТО ТИПО ЧТОБЫ ПЕРЕДЕЛЫВАТЬ МЕТОДЫ КОТОРЫЕ ЕСТЬ В САМОЙ ДЖАВА ТУТ НАПРИМЕР
        //НЕ КОД ОБЪЕКТА А ИМЯ И ВОЗРАСТ
        return name+","+age;
    }
}
