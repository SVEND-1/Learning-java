package org.example.ProdvinytaiJava.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class employee = Class.forName("org.example.ProdvinytaiJava.Reflections.Employee");

        Constructor<Employee> constructor1 = employee.getConstructor();
        Employee object = constructor1.newInstance();

        Constructor constructor2 = employee.getConstructor(int.class,String.class,String.class);
        Object object2 = constructor2.newInstance(5,"Zaur","IT");
        System.out.println(object2);

        Method method = employee.getMethod("setSalary", double.class);
        method.invoke(object2,431.4);//ЗАПУСК МЕТОДА

        System.out.println(object2);
    }
}
