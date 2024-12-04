package org.example.ProdvinytaiJava.AllCollection.Set.LinkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSets {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();//У НЕГО ЕСТЬ ПОРЯДОК
        linkedHashSet.add(5);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(8);
        linkedHashSet.add(10);
        System.out.println(linkedHashSet);
        linkedHashSet.remove(3);
        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.contains(8));
    }
}
