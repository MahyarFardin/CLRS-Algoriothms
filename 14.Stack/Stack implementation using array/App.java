package com.algorithms;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(0);
        stack.push(3);
        stack.push(6);
        stack.push(9);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
