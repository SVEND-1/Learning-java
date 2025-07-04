package org.example.ProdvinytaiJava.AllCollection.Map.Hashcodes;

import java.util.Objects;

public final class Student{//ДЛЯ КЛЮЧА НАДО ПОСТАВИТЬ final ВСЕ
    final String name;
    final String surname;
    final int course;

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
