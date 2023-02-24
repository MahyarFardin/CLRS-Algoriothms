package com.algorithms;

public class App 
{
    public static void main( String[] args )
    {
        redBlackTree my_RBT = new redBlackTree();
        for(int i=1; i<=10; i++){
            my_RBT.insert(i);
        }
        System.out.println("\n*******************************************");
        System.out.println("# insert values in the Tree");
        System.out.print("## Values of Red Block Tree: [ " );
        my_RBT.printTree();
        System.out.print("]" );
        System.out.print("\n###### Tree Values after Deletion: [ ");
        my_RBT.remove(1);
        my_RBT.printTree();
        System.out.print("]" );
        System.out.println("\n*******************************************\n");
    }
}
