package org.example.JavaLite.Serializachia.Three;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private transient String name;//transient чтобы не сериализовывать поле
    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return id + " : " + name;
    }
}

