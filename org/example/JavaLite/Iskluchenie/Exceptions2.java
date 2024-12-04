package org.example.JavaLite.Iskluchenie;

import java.util.Scanner;

public class Exceptions2 {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int  x = Integer.parseInt(scanner.nextLine());
            if(x != 0){
                throw new MyException("НУ ТУТ НЕ 0 ТЫ НАПИСАЛ");
            }

        }
    }
}
