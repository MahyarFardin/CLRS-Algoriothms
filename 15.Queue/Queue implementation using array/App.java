package com.algorithms;

public final class App {
    private App() {
    }


    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        System.out.println(queue.dequeue());
    }
}
