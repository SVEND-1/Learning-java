package org.example.ProdvinytaiJava.AllCollection.Collection.LinkedLists;

import java.util.LinkedList;

public class LinkedListEx1 {
    public static void main(String[] args) {
        Student2 student1 = new Student2("Первый",1);
        Student2 student2 = new Student2("Второй",2);
        Student2 student3 = new Student2("Третий",3);
        Student2 student4 = new Student2("Четвертый",4);
        Student2 student5 = new Student2("Пятый",5);

        LinkedList<Student2> student2LinkedList = new LinkedList<>();
        student2LinkedList.add(student1);
        student2LinkedList.add(student2);
        student2LinkedList.add(student3);
        student2LinkedList.add(student4);
        student2LinkedList.add(student5);
        System.out.println(student2LinkedList);
        System.out.println(student2LinkedList.get(2));//ЭТОТ ЛИСТ ИСПОДЛЬЗОВАТЬ ЛУЧШЕ ЕСЛИ НЕ ИСПОЛЬЗУЕШЬ ПОИСК ПО ИНДЕКСУ НАПРИМЕР get А ПРОСТО add ИЛИ ВЫВОД ВСЕГО

    }
}
class Student2{
    String name;
    int course;

    public Student2(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString(){
        return "Student(name: " + name + " course " + course + ")";
    }
}