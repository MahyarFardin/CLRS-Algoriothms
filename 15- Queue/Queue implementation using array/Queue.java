package com.algorithms;

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
        if(m_tail == items.length){
            throw new IllegalStateException();
        }
        items[m_tail++] = item;
        m_size ++;
    }

    public int dequeue(){
        if(m_size == 0){
            throw new IllegalStateException();
        }
        m_size --;
        return items[m_head++];
    }
}
