package com.algorithms;

// Circular Queue
public class Queue {
    private int[] items;
    private int m_head;
    private int m_tail; 
    private int m_size;

    public Queue(int size){
        items = new int[size];
        m_head = 0;
        m_tail = 0;
        m_size = 0;
    }

    public boolean isEmpty(){
        return m_size == 0;
    }

    public void enqueue(int item){
        if(m_size == items.length){
            throw new IllegalStateException();
        }
        items[m_tail] = item;
        m_tail = (m_tail + 1) % items.length;
        m_size ++;
    }

    public int dequeue(){
        int item = items[m_head];
        items[m_head] = 0;
        m_head = (m_head + 1) % items.length;
        m_size --;
        return item;
    }

}
