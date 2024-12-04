package org.example.JavaLite.Vlozenie;

public class Test {
    public static void main(String[] args) {
        Electrocar electrocar = new Electrocar(1);
        electrocar.start();

        Electrocar.Battery battery = new Electrocar.Battery();//ЭТО СОЗДАНИЯ ТОЖЕ ОБЪЕКТА ТОЛЬКО ВЛОЖЕННОГО

    }
}
