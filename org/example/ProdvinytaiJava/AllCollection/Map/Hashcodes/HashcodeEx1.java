package org.example.ProdvinytaiJava.AllCollection.Map.Hashcodes;

import java.util.HashMap;
import java.util.Map;

public class HashcodeEx1 {
    public static void main(String[] args) {
        Map<Student,Double> map = new HashMap<>();
        Student student1 = new Student("Zaur","Tregulov",3);
        Student student2 = new Student("Mariya","Ivanova",1);
        Student student3 = new Student("Sergey","Petrov",4);
        map.put(student1,7.5);
        map.put(student2,9.4);
        map.put(student3,5.6);
        System.out.println(map);

        Student student4 = new Student("Zaur","Tregulov",3);
        Student student5 = new Student("Igore","Sidorov",4);
        boolean result = map.containsKey(student4);
        System.out.println(result );

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        for(Map.Entry<Student,Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());//ВЫВОДИТ ВСЕ КЛЮЧИ + ЗНАЧЕНИЯ
        }
    }
}

