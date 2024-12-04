package org.example.JavaLite.Interfaces;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal(1);
        animal.sleep();
        Person person = new Person("Bob");
        person.sayHello();

        person.showInfo();
        animal.showInfo();

        Info info = new Animal(1);
        Info info1 = new Person("Bob");
        info.showInfo();
        info1.showInfo(); //ВЫЗЫВАТЬ МОЖНО ТОЛЬКО ТО ЧТО В ИНТЕРФЕЙСА

        outputInfo(info);
        outputInfo(info1);

        outputInfo(animal);
        outputInfo(person);
    }
    public static void outputInfo(Info info){
        info.showInfo();
    }
}
