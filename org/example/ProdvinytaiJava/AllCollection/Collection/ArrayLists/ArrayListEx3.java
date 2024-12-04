package org.example.ProdvinytaiJava.AllCollection.Collection.ArrayLists;

import java.util.ArrayList;

public class ArrayListEx3 {
    public static void show(ArrayList<String> arrayList){
        for(String s: arrayList){
            System.out.print(s + ' ');
        }
    }
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Заур");
        arrayList1.add("Иван");
        arrayList1.add("Мария");

        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("&&&");

        arrayList1.addAll(1,arrayList2);//ДОБАВИТЬ ВСЕ ЭЛЕМЕНТЫ ИЗ ДРУГОГО ЛИСТА ИНДЕКС ЕСЛИ НЕ ПИСАТЬ ТО ПРОСТО ДОБАВИТСЯ В КОНЕЦ
        System.out.println(arrayList1);

        int index = arrayList1.indexOf("Иван");//ЕСЛИ НЕ НАЙДЕН ТО -1 ЧТОБЫ НОРМАЛЬНО ВСЕ В СВОЕМ КЛАССЕ БЫЛО НАДО equals ПЕРЕОПРЕДЕЛЯТЬ
        System.out.println(index);

        int indexLast = arrayList1.lastIndexOf("Иван");//ВЫДАЕТ ПОСЛЕДНЕЕ СОПОДЕНИЕ ДОПУСТИМ ЕСЛИ 3 ИВАНА ВЫДАСТ ПОСЛЕДНЕГО
        System.out.println(indexLast);

        int size = arrayList1.size();
        System.out.println(size);

        boolean isEmpty = arrayList1.isEmpty();//ЕСЛИ ПУСТОЙ ЛИСТ ТО true ЕСТЬ ЕСТЬ ЧТО ТО ТОГДА false
        System.out.println(isEmpty);

        boolean contain = arrayList1.contains("Иван");//ПРОВЕРЯЕТ ЕСТЬ ЛИ ТАКОЙ ОБЪЕКТ В МАССИВЕ ЕСЛИ ДА ТО true НЕТ false
        System.out.println(contain);

        System.out.println(arrayList1.toString());//ПО УМОЛЧАНИЮ ОН УЖЕ ИСПОЛЬЗУЕТСЯ

        arrayList1.clear();
        System.out.println(arrayList1);

    }


}
