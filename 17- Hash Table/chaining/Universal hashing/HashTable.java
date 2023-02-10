package com.company;

import java.util.LinkedList;
import java.util.Random;

public class HashTable {
    LinkedList<Integer>[] hashtable;
    private final int size;
    private final int a;
    private final int b;
    private int p = 101;


    public HashTable(int size) {
        this.size = size;
        hashtable = new LinkedList[size];
        Random generator = new Random();
        a = generator.nextInt(p - 2) + 1;
        b = generator.nextInt(p - 1);
    }

    public int getSize() {
        return size;
    }

    public int function(int key) {
        int h = ((a * key + b) % p) % size;
        return h;
    }

    public void insert(int key) {
        if (hashtable[function(key)] == null) {
            hashtable[function(key)] = new LinkedList();
        }
        hashtable[function(key)].addFirst(key);
    }

    public void delete(int key) {
        if (hashtable[function(key)] == null)
            System.out.println("The element " + key + " is not in the list");
        else hashtable[function(key)].remove((Integer) key);
    }

    public void search(int key) {
        if (!hashtable[function(key)].contains((Integer) key)) {
            System.out.println("not found!");
        } else
            System.out.println("The key is in index " + hashtable[function(key)].indexOf((Integer) key) + " of linkedList which is in slot " + function(key) + " of hashtable ");
        ;
    }
}
