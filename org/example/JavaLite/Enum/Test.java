package org.example.JavaLite.Enum;

public class Test {
    /*
    private static final int DOG =0;//ТАК ДЕЛАЛИ ДО ENUM
    private static final int Cat =1;
    private static final int FROG =2;

     */

    public static void main(String[] args) {
        /*
        int animal = DOG;

        switch (animal){
            case DOG:
                System.out.println("Dog");
                break;
            case FROG:
                System.out.println("Frog");
                break;
            default:
                System.out.println("не животное");
        }*/
        Animal animal = Animal.CAT;

        switch (animal) {
            case DOG:
                System.out.println("Dog");
                break;
            case FROG:
                System.out.println("Frog");
                break;
            case CAT:
                System.out.println("Cat");
                break;
            default:
                System.out.println("не животное");
        }

        Season season = Season.SUMMER;

        switch (season){
            case SUMMER:
                System.out.println("лето");
                break;
            case WINTER:
                System.out.println("зима");
                break;
        }

        Animal animal1 = Animal.DOG;
        Animal animal2 = Animal.CAT;
        Animal animal3 = Animal.FROG;

        System.out.println(animal1.getTrenslation());
        System.out.println(animal2.toString());


        Season season1 = Season.AUTUMN;
        System.out.println(season1.name());//ВЫВОДИТ НАЗВАНИЕ ENUM

        Animal cat3 = Animal.valueOf("CAT");//ТУТ ДОПУСТИМ ЕСЛИ КЕПОЛЬЗОВАТЕЛЬ ВВОДИТ КОШКА ТО ВЫВОДИТ ВСЕ О КОШКЕ кОНСТРУКТОРЕ
        System.out.println(cat3.getTrenslation());

        Season winter3 = Season.WINTER;
        System.out.println(winter3.ordinal());//ПОЛУЧИТЬ ИНДЕКС
    }
}
