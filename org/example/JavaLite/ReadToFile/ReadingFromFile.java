package org.example.JavaLite.ReadToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path = separator + "C:" + separator + "Users" + separator +"7" + separator + "Desktop" + separator +"test.txt";// separator чтобы работал путь и на мак и на виндоус

        File file2 = new File("test2");//ТАК СОЗАДВАТЬ ЕСЛИ СОЗДАТЬ ФАЙЛ В ПАПКЕ С ПРОЕКТОМ
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        /*
        while(scanner.hasNextLine()){//ЦИКЛ СКАНИРУЕТ ВСЕ СТРОКИ ПОКА НЕ ЗАКОНЧАТСЯ ОНИ
            System.out.println(scanner.nextLine());
        }
        */
        String line = scanner.nextLine();//КОГДА ЗНАЕШЬ ЧТО ВСЕГО 1 СТРОКА
        String[] numbers = line.split(" ");// соединяет слова через пробел
        int[] numbersSum = new int[3];
        int counter = 0;

        System.out.println(Arrays.toString(numbers));

        for(String number : numbers){
            numbersSum[counter++] = Integer.parseInt(number);//В ИНТ ПЕРЕВОДИМ
        }

        scanner.close();//вконце надо закрывать всегда

    }
}
