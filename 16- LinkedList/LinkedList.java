package com.algorithms;

public class linkedList<T> {
    private class Node{
        private T m_value;
        private Node m_next;
        private Node m_prev;

        public Node(T value, Node next, Node prev){
            m_value = value;
            m_next = next;
            m_prev = prev;
        }
        public T getValue(){
            return m_value;
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
            m_next = prev;
        }
    }

    private Node m_header;
    private Node m_trailer;
    private int m_size;

    public void LinkedLists(){
        m_header = null;
        m_trailer = null;
        m_size = 0;
    }
    public int size() {
        return m_size;
    }
    public boolean isEmpty() {
        return m_size == 0;
    }
    // add steps
    public void insert(T value){
        Node newNode = new Node(value, null, null);
        if(m_header == null || isEmpty()){
            m_header = m_trailer = newNode;
            m_header.setPrev(null);
            m_trailer.setNext(null);
            m_size++;
        }else{
            m_trailer.setNext(newNode);
            newNode.setPrev(m_trailer);
            m_trailer = newNode;
            m_trailer.setNext(null);
            m_size++;
        }
    }
    public void insertLast(T value){
        Node newNode = new Node(value, null, m_trailer);
        if(m_trailer != null){
            m_trailer.setNext(newNode);
        }
        m_trailer = newNode;
        if(m_header == null || isEmpty()){
            m_header = newNode;
        }
        m_size++;
    }
    // Removal steps
    public void removeFirst() {
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted element: " + m_header.getValue());
        m_header = m_header.getNext();
        m_size--;
    }
    public void removeLast() {
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted element: " + m_trailer.getValue());
        m_trailer = m_trailer.getPrev();
        m_trailer.setNext(null);
        m_size--;
    }
    // Show list
    public void printNodes(){
        Node current = m_header;
        if(m_header == null || isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.print("Nodes of Linked List: [ ");
        while(current != null){
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println("]");
    }
    public T getFirst() {
        if(isEmpty()){
            return null;
        }
        return  m_header.getValue();
    }
    public T getLast() {
        if(isEmpty()){
            return null;
        }
        return m_trailer.getValue();
    }
}