package org.example.JavaLite.Voshod;

public class Test {
    public static void main(String[] args) {
        //ВОСХОДЯЩЕЕ ПРЕОБРАЗОВАНИЕ
        Animal animal = new Dog();//БЛЯ ТИПО СОБАКА БОЛЬШЕ НЕ НАСЛЕДУЕТ СВОИ МЕТОДЫ ,А ВЫШЕ СТАЛА КАК ЖИВОТНОЕ ПО ДЕРЕВУ НАСЛЕДИЯ
        animal.eat();
        Dog dog = new Dog();
        Animal animal1 = dog;
        //НИСХОДЯЩЕЕ
        Dog dog1 =(Dog) new Animal();//ТУТ НАОБОРОТ ПО ДЕРЕВУ НИЖЕ ТЕПЕРЬ КАК СОБАКА


        Animal a = new Animal();//ВОТ ТАК ДЕЛАТЬ НЕПРАВИЛЬНО  У НИСХОДИЩЕЕГО ЕСТЬ РИСК НЕ ТАК СДЕЛАТЬ ЧТО ЛИБО И БУДЕТ ОШИБКА
        Dog dog2 = (Dog) a;
        dog2.bark();
    }
}
