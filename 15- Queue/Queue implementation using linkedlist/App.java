package com.algorithms;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}
