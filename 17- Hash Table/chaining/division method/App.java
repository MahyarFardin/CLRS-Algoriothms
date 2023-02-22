package com.company;

public class App {

    public static void main(String[] args) {

        Hashtable hashTable = new Hashtable(10);
        hashTable.insert(5);
        hashTable.insert(55);
        hashTable.insert(4);
        hashTable.insert(15);
        hashTable.insert(20);
        hashTable.insert(31);
        hashTable.insert(111);
        hashTable.insert(33);
        hashTable.insert(129);

        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.print("index " + i + " : ");
                System.out.println(hashTable.hashtable[i]);
                System.out.println();
            }
        }

        System.out.println();
        hashTable.delete(15);
        hashTable.delete(4);
        hashTable.delete(21);
        for (int i = 0; i < hashTable.getSize(); i++) {
            if (hashTable.hashtable[i] != null) {
                System.out.print("index " + i + " : ");
                System.out.println(hashTable.hashtable[i]);
                System.out.println();
            }
        }
        hashTable.search(4);
        hashTable.search(5);
    }

}
