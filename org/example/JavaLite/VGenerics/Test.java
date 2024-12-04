package org.example.JavaLite.VGenerics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //ДО 5  JAVA
        List animals = new ArrayList();//ТУТ МОГУТ ЛЮБЫЕ ОБЪЕКТЫ БЫТЬ
        Animal ourAnimal = new Animal(3);
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add(ourAnimal);
        animals.add(3);

        String animal = (String) animals.get(2);
        System.out.println(animal);

        // С ПОЯВЛЕНИЯМ ДЖИНЕРИКОВ
        List<String> animals2 = new ArrayList<String>();//ТУТ МОГУТ БЫТЬ ТОК СТРИНГ
        animals2.add("cat");
        animals2.add("dog");
        animals2.add("frog");

        String animal2 = animals2.get(2);
        System.out.println(animal2);

        // С 7 JAVA
        List<String> animals3 = new ArrayList<>();

        //НЕКСТ УРОК

        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        test2(listOfAnimal);

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test2(listOfDogs);

        Object object = new Object();
    }
    private static void test1(List<Animal> list){//ТУТ МОЖНО ВЫВОДИТЬ ТОЛЬКО АНИМАЛ БЕЗ НАСЛЕДОВАНИЯ
        for(Animal animal : list){
            System.out.println(animal);

        }
    }
    private static void test2(List<? extends Animal> list){
        for(Animal animal : list){
            System.out.println(animal);//Вывод всех анимал то есть и классы наследователи
            animal.eat();

        }
    }
    private static void test3(List<? super Dog> list){//ВОТ ТУТ ТИПО ДОГ И ВЫШЕ КЛАССЫ НО НЕ НИЖЕ
        /* for(Animal animal : list){
            System.out.println(animal);
            animal.eat();
            //НО ЭТО НЕ ПОЛЕЗНО

        }

         */
    }
}
