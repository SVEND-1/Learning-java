package org.example.ProdvinytaiJava.AllCollection.Collection.Vectors;

import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector<String> Vector = new Vector<>();
        Vector.add("Zaur");
        Vector.add("Misha");
        Vector.add("Oleg");
        Vector.add("Katya");
        System.out.println(Vector);
        System.out.println(Vector.firstElement());
        System.out.println(Vector.lastElement());

        Vector.remove(2);
        System.out.println(Vector);
        System.out.println(Vector.get(1));
    }
}
