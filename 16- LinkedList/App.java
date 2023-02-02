package com.algorithms;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(0);
        ll.insert(1);
        ll.insert(3);
        ll.insert(9);
        ll.delete(3);
        ll.delete(234);
        System.out.println(ll.search(1));
        System.out.println(ll.search(3));
        
    }
}
