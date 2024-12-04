package org.example.JavaLite.Enum;

public enum Animal {
    DOG("Собака"),
    CAT("Кошка"),
    FROG("Лягушка");

    private String trenslation;
    Animal(String trenslation){
        this.trenslation = trenslation;
    }

    public String getTrenslation(){
        return trenslation;
    }

    public String toString(){
        return "Перевод на русский язык " + trenslation;
    }
}
