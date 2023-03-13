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
        System.out.println("# insert values in the Red_Black_Tree");
        System.out.print("## Values of Red Block Tree: [ " );
        my_RBT.printTree();
        System.out.print("]" );
        System.out.print("\n### Tree Values after Deletion: [ ");
        my_RBT.remove(1);
        my_RBT.printTree();
        System.out.print("]\n" );
        my_RBT.toString();
        System.out.println("*******************************************");

        Interval[] my_intervals_tree = new Interval[4];
        my_intervals_tree[0] = new Interval(33.0, 38.0);
        my_intervals_tree[1] = new Interval(81.0, 96.0);
        my_intervals_tree[2] = new Interval(47.0, 52.0);
        my_intervals_tree[3] = new Interval(19.0, 21.0);
        
        System.out.println("#### Inorder traversal of constructed Interval Tree is: ");
        for (int i = 0; i < my_intervals_tree.length; i++){
            System.out.println(my_intervals_tree[i]);
        }
        System.out.print("*******************************************\n");
    }
}