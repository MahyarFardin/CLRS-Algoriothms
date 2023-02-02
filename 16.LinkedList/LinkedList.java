package com.algorithms;

public class LinkedList {

    private  class Node{

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
    private int m_size;

    public LinkedList(){
        m_head = null;
        m_size = 0;
    }
    public int size(){
        return m_size;
    }
    public boolean isEmpty(){
        return m_size == 0;
    }
    public void insert(int key){
        Node newNode = new Node(key, null, null);
        newNode.setNext(m_head);
        if(m_head != null){
            m_head.setPrev(newNode);
        }
        m_head = newNode;
        newNode.setPrev(null);
        m_size ++ ;
    }

    public void delete(int key){
        Node newNode;
        newNode = m_head;
        while(newNode != null){
            if(newNode.getKey() == key){
                newNode.getPrev().setNext(newNode.getNext());
                newNode.getNext().setPrev(newNode.getPrev());
                m_size --;
                return;
            }
            newNode = newNode.getNext();
        }
        System.out.println("The element "+ key+ " is not in the list");
    }

    public Node search(int key){
        Node newNode;
        newNode = m_head;
        while(newNode != null){
            if(newNode.getKey() == key){
                return newNode;
            }
            newNode = newNode.getNext();
        }
        return null;
    }
}
