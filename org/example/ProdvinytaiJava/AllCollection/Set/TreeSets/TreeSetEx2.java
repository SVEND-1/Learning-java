package org.example.ProdvinytaiJava.AllCollection.Set.TreeSets;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student student1 = new Student("Zaur",3);
        Student student2 = new Student("Mariya",5);
        Student student3 = new Student("Sergey",4);
        Student student4 = new Student("Marina",1);
        Student student5 = new Student("Olya",2);
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);
        System.out.println(treeSet);

        System.out.println(treeSet.first());//ТОТ КТО НА 1  МЕСТО СТОИТ
        System.out.println(treeSet.last());//ТОТ КТО НА ПОСЛЕДНЕМ  МЕСТО СТОИТ

        Student student6 = new Student("oleg",2);
        Student student7 = new Student("Ivan",4);
        System.out.println(treeSet.headSet(student6));//ВЫВОД ВСЕХ СТУДЕНТОВ КОТОРЫЕ УЧАТСЯ НА КУРСЕ НИЖЕ ЧЕМ Oleg

        System.out.println(treeSet.tailSet(student6));//ВЫВОД ВСЕХ СТУДЕНТОВ КОТОРЫЕ УЧАТСЯ НА КУРСЕ ВЫШЕ ИЛИ НА ТОМ ЖЕ САМОМ ЧЕМ Oleg

        System.out.println(treeSet.subSet(student6,student7));//ЭЛЕМЕНТЫ КОТОРЫЕ НАХОДЯТСЯ МЕЖДУ 2 ПОКАЗАТЕЛЯМИ
    }
}

class Student implements Comparable<Student>{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash( course);
    }

    @Override
    public int compareTo(Student o) {
        return this.course - o.course;
    }
}