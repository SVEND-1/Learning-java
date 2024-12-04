package org.example.JavaLite;

public class Static {
    public static void main(String[] args) {
        Stat stat = new Stat("bob",40);
        Stat stat1 = new Stat("Tom",30);
        stat.printNumberOfPeople();
        stat1.printNumberOfPeople();
    }
}

class Stat{
    private String name;
    private int age;
    private static int countPeople;
    public Stat(){
        this.name = "Имя";
        this.age = 0;
    }
    public Stat(String name,int age){
        this.name = name;
        this.age = age;

        countPeople++;//она всего 1 такая переменная когда создается класс то новая переменная статик не создается
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void printNumberOfPeople(){
        System.out.println("Людей работают "+ name + age + "   "+ countPeople);
    }
}