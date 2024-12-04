package org.example.ProdvinytaiJava.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentInfo {
    void testStudents(ArrayList<Student> arrayList,StudentChecks sc){
        for(Student s : arrayList){//ВМЕСТО ВСЕХ ТЕХ 3 ниже 1 МЕТОД И 1  КЛАСС И ВСЕ И МОЖНО  ХОТЬ СКОЛЬКО ДЕЛАТЬ ТАКИХ МЕТОДОВ НО В ДАННОМ ПРИМЕРЕ ТАК ПЛОХО ДЕЛАТЬ
            if(sc.check(s)){
                System.out.println(s);
            }
        }
    }
    void printStidentOverGrade(ArrayList<Student> arrayList,double grede){
        for (Student s : arrayList){
            if(s.avgGrabe > grede){
                System.out.println(s);
            }
        }
    }
    void printStidentUnderAge(ArrayList<Student> arrayList,double age){
        for (Student s : arrayList){
            if(s.age < age){
                System.out.println(s);
            }
        }
    }
    void printStidentsMixCondition(ArrayList<Student> arrayList,double grede,int age,char sex){
        for (Student s : arrayList){
            if(s.age > age && s.avgGrabe < grede && s.sex == sex){
                System.out.println(s);
            }
        }
    }
}

class Test{
    public static void main(String[] args) {
        Student student1 = new Student("Ivan",'m',22,3,8.4);
        Student student2 = new Student("Nikolay",'m',28,2,6.3);
        Student student3 = new Student("Elena",'f',19,1,8.9);
        Student student4 = new Student("Pert",'m',35,4,7);
        Student student5 = new Student("Mariya",'f',23,3,9.8);
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        arrayList.add(student4);
        arrayList.add(student5);

        StudentInfo info = new StudentInfo();

        Collections.sort(arrayList, Comparator.comparing(student -> student.course));//СОРТИРОВКА БЕЗ ОБРАБОТКИ comparebleTo в Student
        Collections.sort(arrayList,(Student s1,Student s2) -> s1.course - s2.course);//СОРТИРОВКА БЕЗ ОБРАБОТКИ comparebleTo в Student
        System.out.println(arrayList);

        info.testStudents(arrayList,new CheckOverGrade());
        System.out.println();
        System.out.println();
        info.testStudents(arrayList,(Student s) -> {return s.age < 30;});//lambda  ТОЖЕ САМОЕ ЧТО НИЖЕ
        info.testStudents(arrayList,(Student s) -> {return s.avgGrabe < 5;});

        System.out.println();
        info.testStudents(arrayList,s -> s.sex == 'm');//САМАЯ КОРОТКАЯ lambda

        StudentChecks sc = s -> s.age > 30;
        info.testStudents(arrayList,sc);

        /*
        info.testStudents(arrayList, new StudentChecks() {//АНОНИМНЫЙ КЛАСС ЛУЧШЕ ТАК  ДЕЛАТЬ ЧЕМ СОЗДАВАТЬ КЛАССЫ
            @Override
            public boolean check(Student s) {
                return s.age < 30;
            }
        });



        info.printStidentOverGrade(arrayList,8);
        System.out.println();
        info.printStidentUnderAge(arrayList,30);
        System.out.println();
        info.printStidentsMixCondition(arrayList,9,20,'f');
         */
    }
}

interface StudentChecks {
    boolean check(Student s);
}

class CheckOverGrade implements StudentChecks{

    @Override
    public boolean check(Student s) {
        return s.avgGrabe > 8;
    }
}