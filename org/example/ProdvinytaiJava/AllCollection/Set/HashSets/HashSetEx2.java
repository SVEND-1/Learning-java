package org.example.ProdvinytaiJava.AllCollection.Set.HashSets;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx2 {
    public static void main(String[] args) {
        Set<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);
        System.out.println(hashSet1);

        Set<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(5);
        hashSet2.add(8);
        System.out.println(hashSet2);

        Set<Integer> hashSetUnion = new HashSet<>(hashSet1);
        hashSetUnion.addAll(hashSet2);//ОБЪЕДИНИТЬ 2 СЕТА БЕЗ ПОВТОРЕНИЯ
        System.out.println(hashSetUnion);

        Set<Integer> hashSetIntersect = new HashSet<>(hashSet1);
        hashSetIntersect.retainAll(hashSet2);//СОДЕРЖИТ ЧИСЛА КОТОРЫЕ ЕСТЬ И В 1 И ВО 2 СЕТЕ
        System.out.println(hashSetIntersect);

        Set<Integer> hashSetSubtract = new HashSet<>(hashSet1);
        hashSetSubtract.removeAll(hashSet2);//УДАЛЯЕТ ВСЕ ЭЛЕМЕНТЫ КОТОРЫЕ ЕСТЬ И В 1 И В 2 СЕТЕ
        System.out.println(hashSetSubtract);
    }
}
