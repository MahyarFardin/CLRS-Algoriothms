package com.algorithms;

public class Stack {
    private DoubleLinkedList dll;

    public Stack(){
        dll = new DoubleLinkedList();
    }

    public boolean isEmpty(){
        return dll.isEmpty();
    }

    public void push(int key){
        dll.insertLast(key);
    }

    public int pop(){
        return dll.deleteLast();
    }
}
