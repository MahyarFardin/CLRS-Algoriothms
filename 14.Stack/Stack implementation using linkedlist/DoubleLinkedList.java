package com.algorithms;

public class DoubleLinkedList {

    private class Node{
        private int m_key;
        private Node m_next;
        private Node m_prev;

        public Node(int key, Node next, Node prev){
            m_key = key;
            m_next = next;
            m_prev = prev;
        }

        public int getKey(){
            return m_key;
        }

        public Node getNext(){
            return m_next;
        }

        public Node getPrev(){
            return m_prev;
        }

        public void setNext(Node next){
            m_next = next;
        }

        public void setPrev(Node prev){
            m_prev = prev;
        }
    }


    private Node m_head;
    private Node m_tail;
    private int m_size;

    public DoubleLinkedList(){
        m_head = null;
        m_tail = null;
        m_size = 0;
    }

    public boolean isEmpty(){
        return m_size == 0;
    }
    public void insertFirst(int key){
        Node newNode = new Node(key, null, null);
        if(m_size == 0){
            m_tail = m_head = newNode;
            m_size ++;
            return;
        }
        m_head.setPrev(newNode);
        newNode.setNext(m_head);
        m_head = newNode;
        m_size ++;
    }

    public void insertLast(int key){
        if(m_size == 0){
            insertFirst(key);
            return;
        }
        Node newNode = new Node(key,null ,null);
        m_tail.setNext(newNode);
        newNode.setPrev(m_tail);
        m_tail = newNode;
        m_size ++;
    }

    public int deleteFirst(){
        if(m_size == 0){
            throw new IllegalStateException();
        }
        int lastHead = m_head.getKey();
        m_head = m_head.getNext();
        if(m_head != null){
            m_head.setPrev(null);
        }
        m_size--;
        return lastHead;
    }

    public int deleteLast(){
        if(m_size == 0){
            throw new IllegalStateException();
        }
        int lastTail = m_tail.getKey();
        m_tail = m_tail.getPrev();
        if(m_tail != null){
            m_tail.setNext(null);
        }
        m_size --;
        return lastTail;
    }





    public void display(){
        Node newNode;
        newNode = m_head;
        while(newNode != null){
            System.out.println(newNode.getKey());
            newNode = newNode.getNext();
        }
    }

}
