package org.example.ProdvinytaiJava.AllCollection.Queue.LinkedLists;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListEx1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();//С ПОМОЩЬЮ ЭТОГО ПИСАТЬ ОЧЕРЕДЬ
        queue.add("Zaur");
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Mariya");
        queue.add("Aleksandr");
        System.out.println(queue);
//ЭТО ДВА ПРИМЕРНО ПОХОЖИХ НО ОТЛИЧАЮТСЯ КОГДА ОЧЕРЕДЬ ОГРАНИЧЕНА ЧЕРЕЗ offer НЕ БУДЕТ ОШИБКИ КОГДА МЕСТА  ЗАКОНЧАТСЯ
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer("Zaur");
        queue2.offer("Oleg");
        queue2.offer("Ivan");
        queue2.offer("Mariya");
        queue2.offer("Aleksandr");
        System.out.println(queue2);
        System.out.println(queue2.remove());//ОБРАБАТЫВАЕТСЯ ВСЕ СНАЧАЛО И ПО ОЧЕРЕДИ ПО ЭТОМУ УДАЛИТСЯ Zaur ЕСЛИ ЭЛЕМЕНТЫ КОНЧИЛИСЬ ТО ВЫБРАСЫВАЕТ ОШИБКУ
        System.out.println(queue2.poll());//ТАКЖЕ УДАЛЯЕТ ЭЛЕМЕНТЫ НО ЕСЛИ ЭЛЕМЕНТЫ КОНЧИЛИСЬ ТО НЕ ВЫБРАСЫВАЕТ ОШИБКУ ПРОСТО ВЕРНЕТ null
        System.out.println(queue2);
        System.out.println(queue2.element());//ПОКАЗЫВАЕТ КТО 1 В ОЧЕРЕДИ КОГДА ВСЕ ЗАКОНЧИЛИСЬ ВЫБРОСИТ ОШИБКУ
        System.out.println(queue2.peek());//ПОКАЗЫВАЕТ КТО 1 В ОЧЕРЕДИ КОГДА ВСЕ ЗАКОНЧИЛИСЬ НЕ ВЫБРОСИТ ОШИБКУ

        queue2.remove("Mariya");//УДАЛИТЬ В СЕРЕДИНЕ ОЧЕРЕДИ НО ЕСЛИ НАДО УДАЛЯТЬ ЧАСТО ГДЕ ТО НО НЕ В НАЧАЛЕ ТО СМЫСЛА ОТ queue НЕТУ
    }
}
