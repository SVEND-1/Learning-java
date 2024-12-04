package org.example.JavaLite.Rekyrsia;

public class Test {

    public static void main(String[] args) {
        System.out.println(fac(4));
    }

    /*
    private static void counter(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        counter(n - 1);

    }
    */
     private static int fac(int n){
         if(n == 1){
             return 1;
         }

         return n * fac(n-1);
     }
}
