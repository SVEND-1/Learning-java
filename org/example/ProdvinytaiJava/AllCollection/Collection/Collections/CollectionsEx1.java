package org.example.ProdvinytaiJava.AllCollection.Collection.Collections;

import java.util.*;

public class CollectionsEx1 {
    public static void main(String[] args) {
        List listAdd = List.of(-3,8,12,-8,0,5,10,1,150,-30,19);

        ArrayList<Integer> arrayList = new ArrayList<>(listAdd);
        System.out.println(arrayList);

        Collections.sort(arrayList);//ВСЕГДА НАДО СОРТИРОВАТЬ БЕЗ НЕЁ НЕ БУДЕТ РАБОТАТЬ КОД НИЖЕ
        System.out.println(arrayList);
        Collections.reverse(arrayList);//РАЗВЕРНУТЬ КОЛЕКЦИЮ
        System.out.println(arrayList);
        Collections.shuffle(arrayList);//РАЗМЕШАТЬ КОЛЛЕКЦИЮ
        System.out.println(arrayList);
        Collections.sort(arrayList);//ВСЕГДА НАДО СОРТИРОВАТЬ БЕЗ НЕЁ НЕ БУДЕТ РАБОТАТЬ КОД НИЖЕ
        System.out.println(arrayList);
        int index = Collections.binarySearch(arrayList,12);// НАХОДИТ ЭЛЕМЕНТ В РАЗЫ БЫСТРЕЕ ЕСЛИ ЭТО БОЛЬШОЙ ЛИСТ ТО ЭТО В РАЗЫ БЫСТРЕЕ
        //СПЕРВА ЛИСТ ПОТОМ ЭЛЕМЕНТ КОТОРЫЙ ИЩЕМ(НЕ ИНДЕКС!!!!) ЕСЛИ ОТРИЦАТЕЛЬНОЕ ЗНАЧЕНИЕ ТО ЗНАЧИТ НЕ НАЙДЕН
        System.out.println(index);


        //ЧУТЬ ДРУГАЯ ЧАСТЬ

        Employee emp1 = new Employee(100,"Zaur",12345);
        Employee emp2 = new Employee(15,"Ivan",6542);
        Employee emp3 = new Employee(123,"Petr",8542);
        Employee emp4 = new Employee(15,"Mariya",5678);
        Employee emp5 = new Employee(182,"Kolya",124);
        Employee emp6 = new Employee(15,"Sasha",9874);
        Employee emp7 = new Employee(250,"Elena",1579);
        List listEmployee = List.of(emp1,emp2,emp3,emp4,emp5,emp6,emp7);//ТАК ДЕЛАЮ Я САМ ЧТОБЫ НЕ ПИСАТЬ 7 РАЗ add()
        ArrayList<Employee> employeeArrayList = new ArrayList<>(listEmployee);
        System.out.println(employeeArrayList);

        Collections.sort(employeeArrayList);//ЧТОБЫ ЭТО РАБОТАЛО НАДО ДОДЕЛАТЬ КЛАСС implements Comparable<Employee>
        System.out.println(employeeArrayList);

        int index2 = Collections.binarySearch(employeeArrayList,new Employee(182,"Kolya",124));//ПОИСК ЭТОГО ЭЛЕМЕНТА НО salary ХОТЬ КАКОЕ ОНО НЕ ВЛИЯЛЕТ И НЕ СРАВНИВАЕТСЯ
        System.out.println(index2);

        //ТО ЖЕ САМОЕ ЧТО И ВЫШЕ ТОЛЬКО ДЛЯ МАССИВОВ
        int[] array = {-3,8,12,-8,0,5,10,1,150,-30,19};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int index3 = Arrays.binarySearch(array,150);
        System.out.println(index3);
    }
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee (id: " + id + " name: " + name + " salary: " + salary + ")";
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        int result = this.id - anotherEmp.id;
        if(result == 0){//ЕСЛИ id ЕСТЬ ОДИНАКОВЫЕ ПОТОМ НЕ ТОЛЬКО id СРАВНИВАТЬ НО И ИМЕНА
            result = this.name.compareTo(anotherEmp.name);
        }
        return result;
    }
}
