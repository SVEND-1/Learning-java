package org.example.ProdvinytaiJava.AllCollection.Map.LinkedHashMaps;


import org.example.ProdvinytaiJava.AllCollection.Map.Hashcodes.Student;

import java.util.LinkedHashMap;

public class LInkedHashMapEx1 {
    public static void main(String[] args) {
        LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);//3 ЭЛЕМЕНТ ОТВЕЧАЕТ КАК БУДЕТ ВЫСТРАИВАТЬСЯ false КАК ОБЫЧНО true сперва те что чаще используются пример в get ЭТИ ЭЛЕМЕНТЫ БУДУТ В КОНЦЕ
        //ОТЛИЧАЕТСЯ ТЕМ ЧТО ТУТ БУДЕТ ПОСЛЕДОВАТЕЛЬНОСТЬ ИНДЕКСОВ КАК ДОБАВИЛИ А ПРОСТО
        //HashMAp  ИДЕТ В РАЗБРОС
        Student student1 = new Student("Zaur","Tregulov",3);
        Student student2 = new Student("Mariya","Ivanova",1);
        Student student3 = new Student("Sergey","Petrov",4);
        Student student4 = new Student("Zaur","Ivanov",2);

        linkedHashMap.put(5.6,student1);
        linkedHashMap.put(6.6,student2);
        linkedHashMap.put(7.4,student3);
        linkedHashMap.put(6.3,student4);

        System.out.println(linkedHashMap);

        System.out.println(linkedHashMap.get(5.6));
        System.out.println(linkedHashMap.get(7.4));

        System.out.println(linkedHashMap);
    }
}
