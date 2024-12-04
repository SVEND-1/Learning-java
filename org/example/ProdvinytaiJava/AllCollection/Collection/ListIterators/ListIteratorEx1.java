package org.example.ProdvinytaiJava.AllCollection.Collection.ListIterators;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx1 {
    public static void main(String[] args) {
        String s = "madam";
        List<Character> list = new LinkedList<>();
        for(char ch : s.toCharArray()){
            list.add(ch);//ДОБАВЛЕНИЕ КАЖДОГО СИМВОВА В МАССИВ
        }
        System.out.println(list);

        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseiterator = list.listIterator(list.size());//В ПАРАМЕТРАХ УКАЗАНО С КАКОЙ ПОЗИЦИИ ОН НАЧИНАЕТ
        boolean isPallindrom = true;
        while (iterator.hasNext() && reverseiterator.hasPrevious()){//ПРОВЕРЯЕТ ЕСТЬ ЛИ ДАЛЬШЕ ЭЛЕМЕНТ А ВТОРОЙ ЕСТЬ ЛИ ДО НЕГО ЭЛЕМЕНТ
            if (iterator.next() != reverseiterator.previous()){//СЛЕДУЮЩИЙ И ПРЕДЫДУЩИЙ ЭЛЕМЕНТ НУ ТИПО ОДИН С СЛЕВО ИДЕТ ДРУГОЙ С ПРАВО ДРУГ К ДРУГУ
                isPallindrom = false;
                break;
            }
        }
        if(isPallindrom){
            System.out.println("Паллиндром");
        }
        else {
            System.out.println("Не паллиндром");
        }
    }
}
