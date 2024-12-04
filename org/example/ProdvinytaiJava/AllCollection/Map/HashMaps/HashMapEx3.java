package org.example.ProdvinytaiJava.AllCollection.Map.HashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapEx3 {
    public static void main(String[] args) {
        Map<Integer,Student> map2 = new HashMap<>(16,0.75f);//ДЛЯ ОПТИМИЗАЦИИ КАК В ЛИСТЕ УСТАНАВЛИВАТЬ КОЛИЧЕСТВО НИЖЕ БОЛЬШЕ НАПИШУ ОБ ЭТОМ
        //ВТОРОЕ ЗНАЧЕНИЕ ЭТО КОФФИЦИЭНТ ТОГО КОГДА БУДЕТ УДВОЕН ЛИСТ ТУТ НАПРИМЕР 16 И 0.75 КОГДА БУДЕТ 12 ТОГДА ЛИСТ УВЕЛИЧИТСЯ
        //ЧЕМ БОЛЬШЕ 1 ЗНАЧЕНИЕ ТЕМ БОЛЬШЕ ЗАНИМАЕТ ПАМЯТИ НО И ТЕМ ПРОИЗОВЕДИТЕЛЬНЕЕ ЧАЩЕ ВСЕГО 0.75 СОЗДАВАТЬ
    }
}

class Student{
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
}
