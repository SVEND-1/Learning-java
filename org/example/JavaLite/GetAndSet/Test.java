package org.example.JavaLite.GetAndSet;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("Имя",10);
        String name = person.getName();
        int age = person.getAge();
        System.out.println(name + age);
    }
}
