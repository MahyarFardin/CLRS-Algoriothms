package com.algorithms;

public class Stack {
     private int[] items;
     private int m_count;

     public Stack(int size){
        items = new int[size];
        m_count = 0;
     }

     public boolean isEmpty(){
        return m_count == 0;
     }
     public void push(int item){
        if(m_count == items.length){
            throw new StackOverflowError();
        }
        items[m_count++] = item;
     }

     public int pop(){
        if(m_count == 0){
            throw new IllegalStateException();
        }
        return items[--m_count];
     }

     public int peek(){
        if(m_count == 0){
            throw new IllegalStateException();
        }
        return items[m_count-1];
     }

}
