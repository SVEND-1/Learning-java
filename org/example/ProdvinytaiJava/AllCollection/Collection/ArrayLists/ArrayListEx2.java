package org.example.ProdvinytaiJava.AllCollection.Collection.ArrayLists;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListEx2 {
    public static void show(ArrayList<String> arrayList){
        for(String s: arrayList){
            System.out.print(s + ' ');
        }
    }
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Заур");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add(1,"Миша");

        show(arrayList1);

        System.out.println();

        System.out.println(arrayList1.get(3));//ВЫВОДИ ЭЛЕМЕНТ С ИНДЕКСОМ В СКОБКАХ

        arrayList1.set(1,"НеМиша");
        System.out.println(arrayList1.get(1));

        arrayList1.remove(3);
        show(arrayList1);
        System.out.println();

        Student student1 = new Student("1 студент",'m',22,3,4.3);
        Student student2 = new Student("2 студент",'m',18,1,3.3);
        Student student3 = new Student("3 студент",'f',14,3,4.6);
        Student student4 = new Student("4 студент",'m',23,2,3.9);
        Student student5 = new Student("5 студент",'f',28,5,4.3);
        ArrayList<Student> arrayListStudent = new ArrayList<>();
        arrayListStudent.add(student1);
        arrayListStudent.add(student2);
        arrayListStudent.add(student3);
        arrayListStudent.add(student4);
        arrayListStudent.add(student5);
        System.out.println(arrayListStudent);
        Student student6 = new Student("5 студент",'f',28,5,4.3);
        arrayListStudent.remove(student6);
        System.out.println(arrayListStudent);
    }
}
class Student{
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }
    @Override
    public String toString(){
        return String.format("Stedent(\nname: %s\nsex: %s\nage: %s\ncourse: %s\n,avgGrade: %s\n",name,sex,age,course,avgGrade);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex && age == student.age && course == student.course && Double.compare(avgGrade, student.avgGrade) == 0 && Objects.equals(name, student.name);
    }

}
