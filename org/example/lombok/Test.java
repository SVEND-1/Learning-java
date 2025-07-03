package org.example.lombok;

public class Test {

    public static void main(String[] args) {
        Movie movie = Movie.builder().build();//Пустой
        Movie m = Movie.builder().id(1).title("1").build();

    }

}
