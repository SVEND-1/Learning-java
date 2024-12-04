package org.example.JavaLite;

public class ClassesAndObjects {
    public static void main(String[] args) {
        Person person = new Person();
        person.setPerson("ЮЮЮ",52);
        person.speak();
        person.sayHello();
        person.calculate();
        int years = person.calculate();

        Person person1 = new Person();

        person1.speak();

    }
}
class Person{
    private String name;
    private int age;

    public void setPerson(String name,int age){
        if (name.isEmpty()){
            System.out.println("Ты ввел пустое имя");
        }
        else {
            this.name = name;
        }
        if(age < 0){
            System.out.println("Не верно ввел возраст");
        }
        else {
            this.age = age;
        }
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    int calculate(){
        int years = 65 - age;
        return years;
    }
    void speak(){
        for(int i = 0; i < 3; i++) {
            System.out.println("Меня зовут " + name + ",мне " + age + " лет");
        }
    }
    void sayHello(){
        System.out.println("ПОНПОН");
    }
}
