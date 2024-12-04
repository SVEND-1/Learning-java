package org.example.ProdvinytaiJava.AllCollection.Collection.Iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class ItaratorEx1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Заур");
        arrayList1.add("Иван");
        arrayList1.add("Мария");

        Iterator<String> iterator = arrayList1.iterator();//ДЛЯ ВЫВОДА ЛИСТА ИЛИ ЧТЕНИЯ
        while (iterator.hasNext()){//ЕСЛИ ЕСТЬ ЕЩЁ ЭЛЕМЕНТЫ
            iterator.next();//БЕЗ ЭТОГО НЕ БУДЕТ РАБОТАТЬ ЭТО ПОЛУЧЕНИЕ ЭЛЕМЕНТА
            iterator.remove();//УДАЛЕНИЕ ВСЕГО ЧТО ЕСТЬ НО МОЖНО ПОСТАВИТЬ if ДОПУСТИМ
        }
        System.out.println(arrayList1);
    }
}
