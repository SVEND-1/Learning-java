package org.example.JavaLite.Anonim;


interface AbleToEat{
    public void eat();
}

class Animal implements AbleToEat{
    @Override
    public void eat(){
        System.out.println("еat");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Animal animal1 = new Animal(){
            public void eat(){
                System.out.println("Изменили метов ит для этой переменной");
            }
        };
        animal1.eat();

        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("Анонимный класс");//СОЗДАЕТСЯ ТАК ТОЛЬКО НА 1 РАЗ ЕСЛИ НАДО ПОМЕНЯТЬ 1 РАЗ МЕТОД В КЛАССЕ
            }
        };

        ableToEat.eat();
    }
}
