package org.example.ProdvinytaiJava.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("privet");
        strings.add("kak dela");
        strings.add("okey");
        strings.add("poka");
        System.out.println(strings);

        for(int i = 0;i < strings.size();i++){
            strings.set(i,String.valueOf(strings.get(i).length()));
        }
        System.out.println(strings);

        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela");
        list.add("okey");
        list.add("poka");

        List<Integer> list2 =  list.stream().map(element -> element.length()).collect(Collectors.toList());//ТОЖЕСАМОЕ ЧТО И ВЫШЕ
        System.out.println(list2);

        int[] array = {5,9,3,8,1};

        array = Arrays.stream(array).map(element -> {
            if(element % 3 == 0){
                element /= 3;
            }
            return element;
        }).toArray();

        System.out.println(Arrays.toString(array));


        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela");
        set.add("okey");
        set.add("poka");
        System.out.println(set);

        Set<Integer> set2 = set.stream().map(element -> element.length()).collect(Collectors.toSet());
        List<Integer> list3 = set.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(set2);
    }
}
