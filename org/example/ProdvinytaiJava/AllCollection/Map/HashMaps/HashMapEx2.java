package org.example.ProdvinytaiJava.AllCollection.Map.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx2 {
    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1000,"Zaur Tregulov");
        map1.put(1234,"Ivan Ivanov");
        map1.put(1543,"Mariya Sidorova");
        map1.put(7563,"Petr Petrov");
        map1.put(1000,"Oleg Ivanov");//КЛЮЧИ НЕЛЬЗЯ ОДИНАКОВЫЕ ТУТ БОЛЬШЕ НЕ БУДЕТ ЗАУРА
        map1.putIfAbsent(1000,"Zaur Tregulov");//ДОБАВИТЬСЯ ТОЛЬКО В ТОМ СЛУЧАЕ ЕСЛИ НЕТУ ТАКОГО УЖЕ КЛЮЧА
       // map1.put(null,"igore Ivanov");ТАК ТОЖЕ МОЖНО
       // map1.put(32413,null);
        System.out.println(map1);
        System.out.println(map1.get(1000));//ПО КЛЮЧУ
        map1.remove(7563);
        System.out.println(map1);

        boolean e1 = map1.containsValue("Ivan Ivanov");//ИЩЕТ ТАКОЕ ЕСТЬ В МАПЕ ЗНАЧЕНИЕ ИЛИ НЕТУ
        System.out.println(e1);
        boolean e2 = map1.containsKey(1000);//ИЩЕТ ТАКОЙ ЕСТЬ В МАПЕ КЛЮЧ ИЛИ НЕТУ
        System.out.println(e2);

        System.out.println(map1.keySet());//ВЫДАЕТ ВСЕ КЛЮЧИ КОТОРЫЕ ЕСТЬ
        System.out.println(map1.values());//ВЫДАЕТ ВСЕ ЗНАЧЕНИЯ КОТОРЫЕ ЕСТЬ

        Map<String,String> map2 = new HashMap<>();
        map2.put("Sasha","Dobriy");
        map2.put("Misha","Good");


    }
}
