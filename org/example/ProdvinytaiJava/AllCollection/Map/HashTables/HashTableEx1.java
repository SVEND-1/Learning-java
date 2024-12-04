package org.example.ProdvinytaiJava.AllCollection.Map.HashTables;

import org.example.ProdvinytaiJava.AllCollection.Map.Hashcodes.Student;

import java.util.Hashtable;

public class HashTableEx1 {
    public static void main(String[] args) {
        Hashtable<Double, Student> hashtable = new Hashtable<>();
        Student student1 = new Student("Zaur","Tregulov",3);
        Student student2 = new Student("Mariya","Ivanova",1);
        Student student3 = new Student("Sergey","Petrov",4);
        Student student4 = new Student("Zaur","Ivanov",2);

        hashtable.put(4.7,student1);
        hashtable.put(5.8,student2);
        hashtable.put(8.3,student3);//С null НЕЛЬЗЯ ДОБАВЛЯТЬ НЕ КЛЮЧ НЕ ЗНАЧЕНИЕ
        hashtable.put(6.7,student4);
        System.out.println(hashtable);
    }
}
