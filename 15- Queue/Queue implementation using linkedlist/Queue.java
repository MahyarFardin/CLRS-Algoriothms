package com.algorithms;

public class Queue {
    private DoubleLinkedList dll;

    public Queue(){
        dll = new DoubleLinkedList();
    }

    public boolean isEmpty(){
        return dll.isEmpty();
    }

    public void enqueue(int item){
        dll.insertLast(item);
    }

    public int dequeue(){
        return dll.deleteFirst();
    }
}
