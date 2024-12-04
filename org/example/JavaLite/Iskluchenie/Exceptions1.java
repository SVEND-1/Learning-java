package org.example.JavaLite.Iskluchenie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("");

        try {
            Scanner scanner = new Scanner(file);
            System.out.println("Тут тоже можно писать код ,НООООО если ошибка выше на строку то уже не выполняется код ниже ,а идет на catch");
        }
        catch (FileNotFoundException e){//ОШИБКА КОГДА ФАЙЛ НЕ НАЙДЕТ
            System.out.println("Файл не найден");;//ЧЕРЕЗ Try/catch ЛУЧШЕ ВСЕГО ДЕЛАТЬ ЧЕМ КАК ТО
        }

        readFile();//НО ТУТ НАДО ТОЖЕ ПИСАТЬ ИСКЛЮЧЕНИЯ
    }

    public static void readFile() throws FileNotFoundException {//throws FileNotFoundException ВОТ ЭТО И В main ТОЖЕ МОЖНО СТАВИТЬ
        File file = new File("");//ТУТ ТАКОЙ ЖЕ КОД КОТОРЫЙ МОГ БЫТЬ В main
        Scanner scanner = new Scanner(file);//ТАКАЯ ЖЕ ОБРАБОТКА
    }
}
