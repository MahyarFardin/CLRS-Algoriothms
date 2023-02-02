package com.algorithms;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }
}
