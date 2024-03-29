package com.company;

import java.util.LinkedList;

public class Hashtable {
    LinkedList<Integer>[] hashtable;
    private int size;
    final static double A = (Math.sqrt(5)-1)/2;

    public Hashtable(int size) {
        this.size = size;
        hashtable = new LinkedList[size];
    }

    public int getSize(){return size;}

    public void insert(int key) {
        int h = (int) Math.floor(size*((key*A)%1));
        if (hashtable[h] == null) {
            hashtable[h] = new LinkedList();
        }
        hashtable[h].addFirst(key);
    }

    public void delete(int key) {
        int h = (int) Math.floor(size*((key*A)%1));
        if (hashtable[h] == null)
            System.out.println("The element " + key + " is not in the list");
        else hashtable[h].remove((Integer) key);
    }

    public void search(int key) {
        int h = (int) Math.floor(size*((key*A)%1));

        if (hashtable[h].indexOf((Integer) key) == -1) {
            System.out.println("not found!");
        } else
            System.out.println("The key is in index " + hashtable[h].indexOf((Integer) key) + " of linkedList which is in slot " + h + " of hashtable ");
        ;
    }


}
