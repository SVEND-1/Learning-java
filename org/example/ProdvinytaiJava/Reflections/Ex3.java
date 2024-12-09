package org.example.ProdvinytaiJava.Reflections;

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10,"Zaur","IT");
        Class eC= employee.getClass();
        Field field = eC.getDeclaredField("salary");

        field.setAccessible(true);//ЧТОБЫ БЫЛ ДОСТУП К private
        double salaryValue = (double) field.get(employee);
        System.out.println(salaryValue);

        field.set(employee,1500);
        System.out.println(employee);
    }
}
