package com.company;

public class App {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(11);

        hashTable.insert(new Entry(35));
        hashTable.insert(new Entry(120));
        hashTable.insert(new Entry(46));
        hashTable.insert(new Entry(57));
        hashTable.insert(new Entry(74));
        hashTable.insert(new Entry(41));
        hashTable.insert(new Entry(7));

        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.println("slot " + i + " is : " + hashTable.hashtable[i].key);
            }

        }
        System.out.println("-------------");
        hashTable.delete(41);
        hashTable.delete(57);
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
        System.out.println(hashTable.search(74));
        System.out.println(hashTable.search(14));
    }
}
