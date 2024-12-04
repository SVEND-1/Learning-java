package org.example.JavaLite.ZapisToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteRoFile {
    public static void main(String[] args) {
        File file = new File("testFile1");
        try {
            PrintWriter pw = new PrintWriter(file);

            pw.println("Тест 1 строки");
            pw.println("Тест 2 строки");//Это запись

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");//САМ ФАЙЛ НИЖЕ НЕ В ЭТОЙ ПАПКЕ
        }

    }
}
