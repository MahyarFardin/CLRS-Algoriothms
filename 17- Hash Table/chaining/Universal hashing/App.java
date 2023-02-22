package com.company;

public class App {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(30);
        hashTable.insert(40);
        hashTable.insert(50);
        hashTable.insert(7);
        hashTable.insert(34);
        hashTable.insert(74);
        hashTable.insert(25);

        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.print("index " + i + " : ");
                System.out.println(hashTable.hashtable[i]);
                System.out.println();
            }
        }
        System.out.println("-----------");
        hashTable.delete(7);
        hashTable.delete(74);
        hashTable.delete(50);
        hashTable.delete(12);

        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.print("slot " + i + " : ");
                System.out.println(hashTable.hashtable[i]);
                System.out.println();
            }
        }
        System.out.println("-----------");
        hashTable.search(25);
        hashTable.search(7);
        hashTable.search(10);
    }
}
