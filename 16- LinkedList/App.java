package com.algorithms;

public class App 
{
     /**
     * @param args
     */
    public static void main( String[] args )
    {
        linkedList<Integer> myList = new linkedList<Integer>();
        for (int i=0; i<=5; i++ ){
            myList.insert(i);
        }
        for (int j=10; j<=15; j++){
            myList.insertLast(j);
        }
        System.out.println("\n");
        myList.printNodes();
        System.out.println("Size is LinkedList = " + myList.size() + "\n" + "********************");
        myList.removeFirst();
        myList.removeLast();
        System.out.println("List size after deletion = " + myList.size());
        myList.printNodes();
        System.out.println("********************");
        System.out.println("\n");
    }
}