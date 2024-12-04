package org.example.ProdvinytaiJava.AllCollection.Map.HashMaps;

import java.util.HashMap;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap<String,Integer> empId = new HashMap<>();//<String,Integer> ключи строки значение числа
        empId.put("John",12345);
        empId.put("Carl",54321);//КАК БАЗА ДАННЫХ
        empId.put("Jerry",123456);
        System.out.println(empId);

        System.out.println(empId.get("Carl"));

        System.out.println(empId.containsKey("Jerry"));//ПРОВЕРКА ЕСТЬ ЛИ ТАКОЙ КЛЮЧ В КАРТЕ

        System.out.println(empId.containsValue(6));//ПРОВЕРКА НА ЗНАЧЕНИЕ ТАМ БЫЛ КЛЮЧ А ТУТ ЗНАЧЕНИЕ ЕСЛИ ВВЕСТИ 12345 ТО БУДЕТ True

        empId.replace("John",777);//КАК UPDETE В БАЗЕ ДАННЫХ

        empId.putIfAbsent("Anlak",7);//СОЗАДАСТ ТОЛЬКО В ТОМ СЛУЧАЕТ ЕСЛИ ТАКОГО ЖЕ КЛЮЧА НЕТУ ЕЩЁ

        empId.remove("Anlak");//КАК DELETE  В SQL
    }
}
