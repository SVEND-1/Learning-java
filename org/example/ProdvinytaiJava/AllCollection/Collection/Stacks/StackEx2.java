package org.example.ProdvinytaiJava.AllCollection.Collection.Stacks;

import java.util.Stack;

public class StackEx2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Zaur");
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Katya");
        System.out.println(stack);
        System.out.println(stack.peek());//ПОСМОТРЕТЬ КАК ЭЛЕМЕНТ НА ВЕРХУ ЦИКЛА
        System.out.println(stack);
/*
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
            System.out.println(stack);
        }

 */
    }
}
