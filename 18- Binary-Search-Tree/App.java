package com.algorithms;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(7);
        tree.insert(5);
        tree.insert(8);
        tree.insert(11);
        tree.insert(15);
        System.out.println("-------------------------PreOrder Traversal-------------------------");
        tree.preorederWalk();
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("-------------------------inOrder Traversal--------------------------");
        tree.inorderWalk();
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("-------------------------PostOrder Traversal------------------------");
        tree.postOrderWalk();
        System.out.println();
        System.out.println("Minimum : "+ tree.minimumValue());
        System.out.println("Maximum : "+ tree.maximumValue());
        tree.deleteValue(9);
        
    }
}
