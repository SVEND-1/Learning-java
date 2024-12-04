package org.example.ProdvinytaiJava.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        int result = list.stream().reduce((accomulator,element) ->accomulator * element).get();//тут это типо accomulator *= element так вот работает
        System.out.println(result);

        int result2 = list.stream().reduce(1,(accomulator,element) ->accomulator * element);//В СКОБКА ПЕРВОЕ ЭТО ЗНАЧЕИЕ  accomulator
        //ПОЛНОСТЬЮ ЭТО ВЫГЛЯДЕТ ПРИМЕРНО ТАК int accomulator = 1; for тут цикл в нем accomulator *= element[i]
        System.out.println(result2);




        List<String> list3 = new ArrayList<>();
        list3.add("privet");
        list3.add("kak dela");
        list3.add("okey");
        list3.add("poka");
        String result3 = list3.stream().reduce((accomulator,element) ->accomulator + " " + element).get();
        System.out.println(result3);




        List<Integer> list100 = new ArrayList<>();//ТАКОЕ РЕДКО ДЕЛАТЬ НО ТУТ ПРОВЕРКА ПУСТОЙ ИЛИ НЕТ ЛИСТ
        Optional<Integer> o = list100.stream().reduce((accomulator, element) ->accomulator * element);
        if(o.isPresent()){
            System.out.println(o.get());
        }
        else{
            System.out.println("Лист пустой");
        }
    }
}
