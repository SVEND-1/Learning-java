package org.example.ProdvinytaiJava.AllCollection.Queue.PriorityQueues;

import java.util.PriorityQueue;

public class PriorityQueueEx1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(10);
        priorityQueue.add(8);

        System.out.println(priorityQueue.peek());//ВЫВОДИТ ПЕРСОЕ ОТСИРТИРОВАННОЕ ЗНАЧЕНИЕ

        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }
}
