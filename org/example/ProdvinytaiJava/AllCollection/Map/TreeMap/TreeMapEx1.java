package org.example.ProdvinytaiJava.AllCollection.Map.TreeMap;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapEx1 {
    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
        Student student1 = new Student("Zaur","Tregulov",3);
        Student student2 = new Student("Mariya","Ivanova",1);
        Student student3 = new Student("Sergey","Petrov",4);
        Student student4 = new Student("Zaur","Ivanov",2);
        Student student5 = new Student("Igore","Sidorov",4);
        Student student6 = new Student("Ivan","Tregulov",3);
        Student student7 = new Student("Ivan","Sidorov",4);
        treeMap.put(5.8,student1);
        treeMap.put(6.6,student7);
        treeMap.put(8.4,student5);
        treeMap.put(4.5,student4);
        treeMap.put(7.7,student3);
        treeMap.put(8.5,student6);
        treeMap.put(4.6,student2);

        System.out.println(treeMap);
        System.out.println(treeMap.tailMap(6.0));//ИЩЕТ ВСЕХ СТУДЕНТОВ У КОГО БОЛЬШЕ  6.0
        System.out.println(treeMap.headMap(6.0));//ИЩЕТ ВСЕХ СТУДЕНТОВ У КОГО МЕНЬШЕ 6.0
        System.out.println(treeMap.lastEntry());//ВЫВОДИТ ПОСЛЕДНИЙ ЭЛЕМЕНТ
        System.out.println(treeMap.firstEntry());//ВЫВОДИТ ПЕРВЫЙ ЭЛЕМЕНТ

        System.out.println(treeMap.get(4.5));
        treeMap.remove(5.8);
        System.out.println(treeMap);
        System.out.println(treeMap.descendingMap());//ВЫВОДИТ ОТ САМОГО БОЛЬШОГО К САМОМУ МЕНЬШЕМУ





        System.out.println("\n\n");

        TreeMap<Student,Double> treeMap1 = new TreeMap<>();//ЧТОБЫ КЛЮЧ СТАЛ НАДО ДЕЛАТЬ УЖЕ ДОПОЛНИТЕЛЬНО В КЛАССЕ НО МОЖНО И КАК НИЖЕ БУДЕТ
        treeMap1.put(student1,5.8);
        treeMap1.put(student7,6.6);
        treeMap1.put(student5,8.4);
        treeMap1.put(student4,4.5);
        treeMap1.put(student3,7.7);
        treeMap1.put(student6,8.5);
        treeMap1.put(student2,4.6);
        System.out.println(treeMap1);

        TreeMap<Student,Double> treeMap2 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //ТУТ ПРОПИСЫВАТЬ ЛОГИКУ СОРТИРОВКИ
                return 1;
            }
        });
    }
}
class Student implements Comparable<Student>{
    String name;
    String surname;
    int course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);//СРАВНИВАЕТСЯ ПО ИМЕННИ ТИПО СОРТИРУТЕСЯ
    }
}
