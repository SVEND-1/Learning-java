package org.example.ProdvinytaiJava.AllCollection.Queue.Deque;

import java.io.FilterOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeEx1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);//ДОБАВИТЬ В НАЧАЛО ОЧЕДЕРИ
        deque.addFirst(5);
        deque.addLast(7);//ДОБАВИТЬ В КОНЕЦ ОЧЕРЕДИ
        deque.offerFirst(1);//ДОБАВИТЬ В НАЧАЛО ОЧЕДЕРИ
        deque.offerLast(8);//ДОБАВИТЬ В КОНЕЦ ОЧЕРЕДИ
        System.out.println(deque);

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());//ЭТО ВСЕ ВЫВОД

        System.out.println(deque.removeFirst());
        System.out.println(deque);
        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
