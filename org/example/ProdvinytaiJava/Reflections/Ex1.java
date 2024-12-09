package org.example.ProdvinytaiJava.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.SortedMap;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employeeClass = Class.forName("org.example.ProdvinytaiJava.Reflections.Employee");
 //       Class employeeClass2 = Employee.class;
   //     Employee employee = new Employee();
     //   Class employeeClass3 = employee.getClass();

        Field field = employeeClass.getField("id");//ПОЛУЧИТЬ ПОЛЕ В АРГУМЕНТЫ ИМЯ ПОЛЕ
        System.out.println("тип поля " + field.getType());

        System.out.println("----------------");

        Field [] fields = employeeClass.getFields();//ВОЗВРАЩАЕТ ВСЕ ПОЛЯ
        for(Field field1 : fields){
            System.out.println(field1.getName() + "  " + field1.getType());//ВСЕ КРОМЕ private
        }

        System.out.println("----------------");

        Field [] allFields = employeeClass.getDeclaredFields();
        for(Field field1 : allFields){
            System.out.println(field1.getName() + "  " + field1.getType());//ВСЕ ПОЛЯ ДАЖЕ private
        }

        System.out.println("----------------");

        Method method = employeeClass.getMethod("increaseSalary");
        System.out.println(method.getName() + " : " + method.getReturnType() + " : " + Arrays.toString(method.getParameterTypes()));

        Method method2 = employeeClass.getMethod("setSalary",double.class);
        System.out.println(method2.getName() + " : " + method2.getReturnType() + " : " + Arrays.toString(method2.getParameterTypes()));

        System.out.println("----------------");

        Method [] methods = employeeClass.getMethods();
        for(Method method1 : methods) {
            System.out.println(method1.getName() + "  " + method1.getReturnType() + " " + Arrays.toString(method2.getParameterTypes()));
        }

        System.out.println("----------------");

        Method [] methods2 = employeeClass.getDeclaredMethods();
        for(Method method1 : methods2) {
            System.out.println(method2.getName() + "  " +
                    method1.getReturnType() + " " + Arrays.toString(method2.getParameterTypes()));//ТУТ И private ТОЖЕ БУДУТ
        }

        System.out.println("----------------");

        Method [] methods3 = employeeClass.getDeclaredMethods();
        for(Method method1 : methods3) {
            if (Modifier.isPublic(method1.getModifiers())) {//ВЫВЕДЕТ ТОЛЬКО public ПОЛЯ
                System.out.println(method2.getName() + "  " +
                        method1.getReturnType() + " " + Arrays.toString(method2.getParameterTypes()));//ТУТ И private ТОЖЕ БУДУТ
            }
        }

        System.out.println("----------------");

        Constructor constructor1 = employeeClass.getConstructor();//ПОЛУЧТЬ КОНСТРУКТОР БЕЗ ПАРАМЕТРОВ
        System.out.println(constructor1.getParameterCount() + " : " + Arrays.toString(constructor1.getParameterTypes()));//СКОЛЬКО ПАРАМЕТРОВ ,ТИПЫ ПАРАМЕТРОВ

        Constructor constructor2 = employeeClass.getConstructor(int.class,String.class,String.class);//ПОЛУЧИТЬ КОНСТРУКТОР С ТАКИМИ ПАРАМЕТРАМИ
        System.out.println(constructor2.getParameterCount() + " : " + Arrays.toString(constructor2.getParameterTypes()));

        System.out.println("----------------");

        Constructor [] constructors = employeeClass.getConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "  " +
                    constructor.getParameterCount() + " " + Arrays.toString(constructor.getParameterTypes()));
        }
        System.out.println("----------------");

        Constructor [] constructors2 = employeeClass.getDeclaredConstructors();
        for(Constructor constructor : constructors2) {
            System.out.println(constructor.getName() + "  " +
                    constructor.getParameterCount() + " " + Arrays.toString(constructor.getParameterTypes()));//ТУТ И private ТОЖЕ БУДУТ
        }

    }
}
