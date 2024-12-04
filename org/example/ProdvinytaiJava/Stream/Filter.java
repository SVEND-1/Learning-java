package org.example.ProdvinytaiJava.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {
        Student student1 = new Student("1 студент",'m',22,3,4.3);
        Student student2 = new Student("2 студент",'m',18,1,3.3);
        Student student3 = new Student("3 студент",'f',14,3,4.6);
        Student student4 = new Student("4 студент",'m',23,2,3.9);
        Student student5 = new Student("5 студент",'f',28,5,4.3);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        List<Student> studentList2 = studentList.stream().filter(element -> element.getAge() > 22 && element.getAvgGrade() > 4).collect(Collectors.toList());
        System.out.println(studentList2);

        Stream<Student> myStream = Stream.of(student1,student2,student3,student4,student5);
        myStream.filter(element -> element.getAge() > 22 && element.getAvgGrade() > 4).collect(Collectors.toList());//ТОЖЕ САМОЕ ЧТО И ВЫШЕ
    }
}
class Student{
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, course, avgGrade);
    }
}
