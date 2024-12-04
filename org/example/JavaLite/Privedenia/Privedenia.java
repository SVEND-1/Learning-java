package org.example.JavaLite.Privedenia;

public class Privedenia {
    public static void main(String[] args) {
        float f = 123.2f;

        int a = 123;

        long l = a;//ПРИВЕДЕНИЕ НЕ ТИПО ПРИЗРАК ,А ТИПО из int можно привести в long
        int x =(int) l;//ИЗ ЛОНГ В ИНТ ПРОСТО ТАК НЕ ДЕЛАЕТСЯ И ВОТ НАДО ПИСАТЬ В СКОБКАХ
        System.out.println(x);

        int s = 123;
        double o = a;
        System.out.println(o);

        double d = 123.5;
        int q = (int) d;
        System.out.println(q);
    }
}
