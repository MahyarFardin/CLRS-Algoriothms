package com.company;

public class App {


    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        Entry example1 = new Entry(2, "amir");
        Entry example2 = new Entry(1, "sara");
        Entry example3 = new Entry(9, "hossein");
        Entry example4 = new Entry(11, "sina");
        Entry example5 = new Entry(7, "zahra");
        Entry example6 = new Entry(1, "reza");
        Entry example7 = new Entry(10, "sahar");
        Entry example8 = new Entry(0, "mahyar");

        hashTable.insert(example1);
        hashTable.insert(example2);
        hashTable.insert(example3);
        hashTable.insert(example4);
        hashTable.insert(example5);
        hashTable.insert(example6);
        hashTable.insert(example7);
        hashTable.insert(example8);

        System.out.println();

        //print
        for (int i = 0; i < hashTable.size; i++) {
            if (hashTable.hashTable[i] != null)
                System.out.println("index is : " + hashTable.hashTable[i].key + " ---- " + "data is :" + hashTable.hashTable[i].value);
        }

        System.out.println();

        System.out.println(hashTable.search(1));
        System.out.println(hashTable.search(3));

        System.out.println();

        hashTable.delete(2);
        hashTable.delete(8);

        for (int i = 0; i < hashTable.size; i++) {
            if (hashTable.hashTable[i] != null)
                System.out.println("index is : " + hashTable.hashTable[i].key + " ---- " + "data is :" + hashTable.hashTable[i].value);
        }


    }

}
