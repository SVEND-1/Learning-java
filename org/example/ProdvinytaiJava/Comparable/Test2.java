package org.example.ProdvinytaiJava.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee(100,"Zaur","tregulov",12345);
        Employee employee2 = new Employee(15,"Ivan","Petrov",6542);
        Employee employee3 = new Employee(123,"Ivan","Sidorov",8542);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}


class Employee implements Comparable<Employee>{
    int id;
    String name;
    String surname;
    int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        if(this.id == o.id){
            return 0;
        }
        else if(this.id < o.id){
            return -1;
        }
        else{
            return 1;
        }
        //ЕСЛИ РАВНЫ ТО 0 ЕСЛИ БОЛЬШЕ ТО >0 ЕСЛИ МЕНЬШЕ ТО <0
        //МОЖНО 1 СТРОЧКОЙ return this.id - o.id;
        //для String this.name.compareTo(o.name)

        //СДЕЛАТЬ ПРОВЕРКУ СПЕРВА ПО ИМЕНИ ПОТОМ ПО ФАМАЛИИ
        //int result = this.name.compareTo(o.name)
        //if(result == 0){
          //  result = return this.surname.compareTo(o.surname);
        //}
    }
}

