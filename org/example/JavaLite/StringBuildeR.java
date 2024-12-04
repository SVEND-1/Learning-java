package org.example.JavaLite;

public class StringBuildeR {
    public static void main(String[] args) {
        String x ="Hello";
        x = x.toUpperCase();
        System.out.println(x);

        int s = 5;

        String string1 = "hello";
        String string2 = " my";
        String string3 = " friend";
        String stringAll = string1 + string2 + string3;
        System.out.println(stringAll);

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb.toString());
        sb.append(" my")
                .append(" friend");
        System.out.println(sb.toString());//ЧТОБЫ МЕНЯТЬ СТРОКИ ЧАСТО НАДО ЭТО

        // ФОРМАТИРОВАНИЯ СТРОК
        System.out.printf("слово %s ещё слово %s",s,string3);//ВМЕСТО ГДЕ %S МОЖНО ПОСТАВИТЬ ПЕРЕМЕННУЮ
        System.out.println();
        System.out.printf("слово %d",8);//ДЛЯ ЦИФР
        System.out.println();
        System.out.printf("слово %f",313.4);//ДЛЯ ФЛОАТ
        System.out.println();
        System.out.printf("слово %f слово %s слово %d",4.1,sb,s);// МОЖНО И ТАК ВСЕ ВМЕСТЕ
        System.out.println();
        //ЕСТЬ И ПО ДЕФОЛТУ \n
        System.out.printf("Слово %10d \n",312);
        System.out.printf("Слово %10d \n",34324);
        System.out.printf("Слово %10d \n",132);
        System.out.printf("Слово %10d \n",54312);//ТИПО ВСЕ БУДЕТ РОВНО ОТСТУП 10 ПОСТАВИЛ ПЕРЕД d
        //ЩАС БУДЕТ ПОЛЕ МЕНЕЕ ПОЛЕЖНОЕ ПРЯМ
        System.out.printf("ТИПО ЧТО ТО %.3f \n",31.41324);//ОКРУГЛЯЕТСЯ Я ПОСТАВИЛ ПОСЛЕ 3 СИМВОЛОВ
    }
}
