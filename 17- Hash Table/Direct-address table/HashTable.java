package com.company;


public class HashTable {

    int size;
    Entry[] hashTable;

    public HashTable(int size) {
        this.size = size;
        hashTable = new Entry[size];
    }

    public void insert(Entry entry) {
        if (entry.key > size - 1) {
            System.out.println("this key has already been entered");
        } else if (hashTable[entry.key] != null)
            System.out.println("the key is larger than size of hashtable");
        else {
            hashTable[entry.key] = entry;
            System.out.println("entered!");
        }
    }
    
    public String search(int key) {
        if (hashTable[key] == null) {
            System.out.println("not found!");
            return null;
        } else return hashTable[key].value;
    }


    public void delete(int key) {
        if (hashTable[key] == null)
            System.out.println("there is nothing in index " + key + " to delete");
        else hashTable[key] = null;
    }

}

class Entry {

    protected int key;
    protected String value;

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
