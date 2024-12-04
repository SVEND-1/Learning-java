package org.example.JavaLite.Equals;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);

        System.out.println(animal1.equals(animal2));

        String string1 = "Hello";
        String string2 = "Hello";

        System.out.println(string1.equals(string2));
    }
}

class Animal{
    private int id;

    public Animal(int id){
        this.id = id;
    }

    public boolean equals(Object obj){//ПЕРЕДЕЛЫВАЙ ПОД КЛАСС СРАВНЕНИЕ ИНАЧЕ ОНО ПРОВЕРЯЕТ ПРОСТО ПУТЬ
        Animal otherAnimal = (Animal) obj;
        return this.id == otherAnimal.id;
    }
}
