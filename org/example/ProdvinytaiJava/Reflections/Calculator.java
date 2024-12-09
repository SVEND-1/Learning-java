package org.example.ProdvinytaiJava.Reflections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void sum(int a,int b){
        int result = a + b;
        System.out.println(result);
    }
    void sub(int a,int b){
        int result = a - b;
        System.out.println(result);
    }
    void mult(int a,int b){
        int result = a * b;
        System.out.println(result);
    }
    void dev(int a,int b){
        if(b != 0) {
            System.out.println("Делить на 0 нельзя");
        }
        else{
            int result = a / b;
            System.out.println(result);
        }
    }
}

class TestCalculator{
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        try (BufferedReader reader = new BufferedReader(new FileReader("test100.txt"))){
            String methodName = reader.readLine();
            String firstArg = reader.readLine();
            String lastArg = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;

            Method[] methods =  cl.getDeclaredMethods();
            for(Method method1 : methods){
                if(method1.getName().equals(methodName)){
                    method = method1;
                }
            }
            method.invoke(calculator,Integer.parseInt(firstArg),Integer.parseInt(lastArg));
        }
    }
}
