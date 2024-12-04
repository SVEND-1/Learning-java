package org.example.JavaLite.AbstraktniClass;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        //АБСТРАКТНЫЙ КЛАСС НЕ СОЗДАЕТСЯ ,НО ЯВЛЯЕТСЯ ОСНОВОЙ ДЛЯ ДРУГИХ ЕГО НАСЛЕДНИКОВ
        cat.mobeSound();
        dog.mobeSound();
    }
}
