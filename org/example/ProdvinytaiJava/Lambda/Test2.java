package org.example.ProdvinytaiJava.Lambda;

public class Test2 {
    static void  def(String s,I i){
        System.out.println(i.abc(s));
    }
    static void def2(J j){
        System.out.println(j.abc());
    }

    public static void main(String[] args) {
        final int d = 10;
        def("d",(String s) -> {
            int i = 5;
            System.out.println(d);
            return s.length();
        });


        def2(() -> 5);

    }
}

interface I{
    int abc(String s);
}
interface J{
    int abc();
}