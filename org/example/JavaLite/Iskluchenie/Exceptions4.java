package org.example.JavaLite.Iskluchenie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


public class Exceptions4 {
    public static void main(String[] args) {

        /*
        try {
            run();
        } catch (IOException e) {//IllegalArgumentException ЭТО НЕ ВЫКИДЫВАЕМ ПОТОМУ ЧТО ОН НАСЛЕДУЕТСЯ ОТ ЭТОГО
            System.out.println();
        } catch (ParseException e) {
            System.out.println();
        }
        */

        /*
        try {
            run();
        } catch (IOException | ParseException e) {//МОЖНО ВСЕ ИСКЛЮЧЕНИЕ С 1 И ТЕМ ЖЕ ОТВЕТОМ
            System.out.println();
         */

        try {
            run();
        } catch (Exception e) {//ТУТ ОБРАБАТЫВАЮТСЯ ВСЕ ОШИБКИ КОТОРЫЕ ЕСТЬ
            System.out.println();//ЕСЛИ ХОТИТЕ ОБРАБОТАТЬ НАПРИМЕР ParseException НАДО СТАВИТЬ catch ВЫШЕ ЧЕМ Exception
        }

    }

    public static void run() throws IOException, ParseException, IllegalArgumentException{

    }
}
