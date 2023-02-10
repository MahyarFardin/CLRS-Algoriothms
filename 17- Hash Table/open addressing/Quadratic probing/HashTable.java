package com.company;

public class HashTable {
    Entry[] hashtable;
    private int size;
    private int i = 0;
    private Entry deleted = new Entry(-1);
    private int c1;
    private int c2;

    public HashTable(int size, int c1, int c2) {
        this.size = size;
        this.c1=c1;
        this.c2=c2;
        hashtable = new Entry[size];
    }

    public int getSize() {
        return size;
    }

    public int function(int key) {
        int h =  ((key % size) + c1*i + c2*(i*i)) % size;
        return h;
    }

    public void insert(Entry a) {
        i = 0;
        for (int j = 0; j < size; j++) {
            if (hashtable[function(a.key)] != null && hashtable[function(a.key)] != deleted) {
                i++;
            } else {
                hashtable[function(a.key)] = a;
                break;
            }
            if (i == size - 1) {
                System.out.println("hash table overflow");
            }
        }
    }

    public void delete(int key) {
        i = 0;
        for (int j = 0; j < size; j++) {
            if (hashtable[function(key)] == null || hashtable[function(key)] == deleted) {
                System.out.println("nothing found to delete!");
                break;
            } else if (hashtable[function(key)].key == key) {
                hashtable[function(key)] = deleted;
                System.out.println("deleted");
                break;
            } else i++;
            if (i == size - 1) {
                System.out.println("nothing found to delete!");
            }
        }
    }

    public int search(int key) {
        i = 0;
        for (int j = 0; j < size; j++) {
            if (hashtable[function(key)] == null || hashtable[function(key)] == deleted) {
                return -1;
            } else if (hashtable[function(key)].key == key) {
                return function(key);
            } else i++;
        }
        return -1;
    }
}

class Entry {
    protected int key;

    public Entry(int key) {
        this.key = key;
    }
}
