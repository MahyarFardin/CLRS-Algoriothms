package com.company;

public class App {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(11,3,1);

        hashTable.insert(new Entry(7));
        hashTable.insert(new Entry(25));
        hashTable.insert(new Entry(46));
        hashTable.insert(new Entry(59));
        hashTable.insert(new Entry(89));
        hashTable.insert(new Entry(93));
        hashTable.insert(new Entry(62));

        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.println("slot " + i + " is : " + hashTable.hashtable[i].key);
            }

        }
        System.out.println("-------------");
        hashTable.delete(93);
        hashTable.delete(46);
        hashTable.delete(12);
        System.out.println("------------");
        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.println("slot " + i + " is : " + hashTable.hashtable[i].key);
            }

        }
        System.out.println("-----------");
        hashTable.insert(new Entry(45));
        hashTable.insert(new Entry(54));
        hashTable.insert(new Entry(61));
        hashTable.insert(new Entry(77));

        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.println("slot " + i + " is : " + hashTable.hashtable[i].key);
            }

        }
        System.out.println("------------");
        System.out.println(hashTable.search(62));
        System.out.println(hashTable.search(14));
    }
}
