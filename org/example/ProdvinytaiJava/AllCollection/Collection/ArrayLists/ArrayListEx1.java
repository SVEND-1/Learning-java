package org.example.ProdvinytaiJava.AllCollection.Collection.ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Заур");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>(30);//ИЗНАЧАЛЬНО МАССИВ СОСТОИТ ИЗ 10 НО МОЖНО ПОМЕНЯТЬ ЕСЛИ ЗНАЕШЬ СКОЛЬКО +- БУДЕТ СОДЕРЖАТЬ МАССИВ  ТО ЛУЧШЕ УКАЗАТЬ
        arrayList2.add("Заур");
        arrayList2.add("Иван");


        List<String> arrayList3 = new ArrayList<>();//ЭТО ТОЖЕ СОЗДАТЬСЯ ArrayList

        ArrayList<String> arrayList4 = new ArrayList<>(arrayList1);//ЭТО ТИПО СКОПИРОВАТЬ ПРОШЛЫЙ ЛИСТ

        ArrayList arrayList5 = new ArrayList<>();//ЕСЛИ ТАК СОЗДАВАТЬ ТО МОЖНО ХОТЬ ЧТО ПИХАТЬ НО ЛУЧШЕ ТАК НЕ ДЕЛАТЬ
        arrayList5.add("Иван");
        arrayList5.add("Мария");
        arrayList5.add(7);
        arrayList5.add(true);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(4);
        integers.add(7);
        integers.add(3);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);
    }
}
