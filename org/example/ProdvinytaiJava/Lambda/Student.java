package org.example.ProdvinytaiJava.Lambda;

public class Student {
    String name;
    char sex;
    int age;
    int course;
    double avgGrabe;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrabe=" + avgGrabe +
                '}';
    }

    public Student(String name, char sex, int age, int course, double avgGrabe) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrabe = avgGrabe;
    }
}
