package org.example.ProdvinytaiJava.AllCollection.Collection.ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx4 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");

        StringBuilder [] array = {sb1,sb2,sb3,sb4};
        List<StringBuilder> list = Arrays.asList(array);
        System.out.println(list);

        array[0].append("!!!");//ДОПОЛНЕНИЕ ЭЛЕМЕНТА
        array[0] = new StringBuilder("F");//ЗАМЕНА ЭЛЕМЕНТА
        System.out.println(list);

        //ЭТО ВООБЩЕ ДРУГАЯ ТЕМА НИЖЕ ЭТО 2 ТЕМЫ

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Заур");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("???");
        arrayList2.add("Иван");
        arrayList2.add("!!!");

        boolean result = arrayList1.contains(arrayList2);//ПРОВЕРЯЕТ СОДЕРЖИТ ЛИ ВСЕ ЭЛЕМЕНТЫ В 2 ЛИСТА В ПЕРВОМ
        //ТИПО ВЕРНУЛО БЫ true ЕСЛИ ЕЩЁ В 1 ЛИСТЕ БЫЛО !!! И ???
        System.out.println(result);

        Object[] array2 = arrayList1.toArray();//СОЗДАТЬСЯ ЛИСТ СО ВСЕМИ ЗНАЧЕНИЯМИ ИЗ arrayList1

        String[] array3 = arrayList1.toArray(new String[5]);//ЕСЛИ БОЛЬШЕ ЭЛЕМЕНТОВ ТО ВЫВЕДЕТСЯ МЕНЬШЕ ТОЛЬКО СТОЛЬКО СКОЛЬКО ПОСТАВИЛ ЕСЛИ МЕНЬШЕ ВСЕ ОСТАЛЬНОЕ БУДЕТ null
        for(String s : array3){
            System.out.println(s + "  ");
        }

        List<Integer> list1 = List.of(3,7,13);//ПРОСТО СОЗДАНИЯ ЛИСТА И УКАЗЫВАНИЕ ЧТО В НЕМ БЕЗ МЕТОДА add НО МЕНЯТЬ НЕЛЬЗЯ ЭТО final И НЕ МОЖЕТ СОДЕРЖАТЬ ЗНАЧЕНИЕ null
        System.out.println(list1);

        List<String> list2 = List.copyOf(arrayList1);//КОПИРУЕТ arrayList1 И ТУТ ТОЖЕ ПОТОМ list2 БУДЕТ final И НЕ МОЖЕТ СОДЕРЖАТЬ ЗНАЧЕНИЕ null
        System.out.println(list2);

        List<String> myList = arrayList1.subList(1,3);//ВОЗВРАЩАЕТ В ЛИСТ ВСЕ ЭЛЕМЕНТЫ ОТ И ДО КОТОРОГО ИНДЕКСА ПОСТАВИШЬ В СКОБКАХ И ЕСЛИ НАДО ВЫВЕСТИ 3 ИНДЕКСТ ДО НАДО СТАВИТЬ 4 ТИПО n+1
        System.out.println(myList);
        myList.add("Fedor");//ТУТ ДОБАВИТСЯ КАК В ТОТ ТАК И В ДРУГОЙ ЛИСТ ЭТО ПРОСТО КАК ЦИТАТА ИЛИ ПЕРЕСКАЗ НА АНГЛ ЭТо View
        System.out.println(myList);
        System.out.println(arrayList1);//ЕСЛИ ДЕЛАТЬ ТАКОЙ ЛИСТ ТО И ИЗМЕНЯТЬ ЕГО НАДО НЕ ЧЕРЕЗ arrayList1 А ЧЕРЕЗ myList


        arrayList1.retainAll(arrayList2);//ОСТАВЛЯЕТ В ЛИСТЕ ТОЛЬКО ТЕ ЭЛЕМЕНТЫ КОТОРЫЕ И В ТОМ И В ДРУГОМ ЛИСТЕ ЕСТЬ
        System.out.println(arrayList1);

        arrayList1.removeAll(arrayList2);//УДАЛЯЕТ ВСЕ ОБЪЕКТЫ КОТОРЫХ И В ТОМ И В ДРУГОМ НАХОДЯТСЯ НО УДАЛЯЕТ ТОЛЬКО В ДАННЫЙ МОМЕНТ У arrayList1
        System.out.println(arrayList1);

    }
}
