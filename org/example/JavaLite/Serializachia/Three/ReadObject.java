package org.example.JavaLite.Serializachia.Three;

import org.example.JavaLite.Serializachia.One.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("people2.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            int personCount = ois.readInt();
            org.example.JavaLite.Serializachia.One.Person[] people = new org.example.JavaLite.Serializachia.One.Person[personCount];
            for(int i = 0; i < personCount;i++){//ЦИКЛ СМОТРИТ СКОЛЬКО В МАССИВЕ ДАННЫХ И ЧИТАЕТ ВСЕ
                people[i] = (org.example.JavaLite.Serializachia.One.Person) ois.readObject();
            }

            System.out.println(Arrays.toString(people));

            org.example.JavaLite.Serializachia.One.Person[] person = (Person[]) ois.readObject();//МОЖНО И ТАК МАССИВ ДЕЛАТЬ
            System.out.println(Arrays.toString(person));

            //       Person person1 = (Person) ois.readObject();
            //     Person person2 = (Person) ois.readObject();

            // System.out.println(person1 + "   " + person2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
