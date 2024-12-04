package org.example.JavaLite.Serializachia.Three;

import org.example.JavaLite.Serializachia.One.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        //   Person person1 = new Person(1,"bob");
        // Person person2 = new Person(2,"Mide");
        org.example.JavaLite.Serializachia.One.Person[] people = {new org.example.JavaLite.Serializachia.One.Person(1,"bob"),new org.example.JavaLite.Serializachia.One.Person(2,"Mide"),new org.example.JavaLite.Serializachia.One.Person(3,"Tom")};

        try {
            FileOutputStream fos = new FileOutputStream("people2.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(people.length);

            for(Person person : people){//ЦИКЛ ПО ВСЕМ person В МАССИВЕ
                oos.writeObject(person);
            }

            //      oos.writeObject(people);//МОЖНО И ТАК МАССИВ ДЕЛАТЬ

            //           oos.writeObject(person1);
            //         oos.writeObject(person2);

            oos.close();
        }
        catch (IOException e){
            System.out.println("Файл не найден");
        }
    }
}