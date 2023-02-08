package com.algorithms;

public class Tree {
    
    private class Node {
        private int m_value;
        private Node m_leftChild;
        private Node m_rightChild;

        public Node(int value){
            m_value = value;
            m_leftChild = null;
            m_rightChild = null;
        }

        public int getValue(){
            return m_value;
        }

    }

    private Node m_root;

    public Tree() {
        m_root = null;
    }
    
    public void insert(int value) {
        Node newNode = new Node(value);
        if (m_root == null){
            m_root = newNode;
            return;
        }
        Node current = m_root;
        while (true){
            if (value < current.getValue()){
                if (current.m_leftChild == null){
                    current.m_leftChild = newNode;
                    break;
                }
                current = current.m_leftChild;
            }
            else {
                if (current.m_rightChild == null){
                    current.m_rightChild = newNode;
                    break;
                }
                current = current.m_rightChild;
            }
        }
    }

    public boolean contains(int value){
        Node current = m_root;
        while(current != null){
            if(value < current.m_value){
                current = current.m_leftChild;
            }
            else if(value > current.m_value){
                current = current.m_rightChild;
            }
            else{
                return true;
            }
        }
        return false;
    }

    private Node minimum(Node root){
        Node current = m_root;
        while (current.m_leftChild != null){
            current = current.m_leftChild;
        }
        return current;
    }

    public int minimumValue(){
        return minimum(m_root).m_value;
    }

    private Node maximum(Node root){
        Node current = m_root;

        while (current.m_rightChild != null){
            current = current.m_rightChild;
        }
        return current;
    }

    public int maximumValue(){
        return maximum(m_root).m_value;
    }

    public void successor(Node root, Node x){
        if (x.m_rightChild != null){
            Node s = minimum(x.m_rightChild);
            System.out.println(s.m_value);
        }

        if (x.m_rightChild == null){
            Node m = maximum(root);
            if (m == x){
                System.out.println("No successor");
            }
            else{

            }
        }
        
    }
    
    private void preorederWalk(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.m_value+ ", ");
        preorederWalk(root.m_leftChild);
        preorederWalk(root.m_rightChild);
    }

    public void preorederWalk(){
        preorederWalk(m_root);
    }

    private void inorderWalk(Node root){
        if (root == null){
            return;
        }

        inorderWalk(root.m_leftChild);
        System.out.print(root.m_value+ ", ");
        inorderWalk(root.m_rightChild);
    }

    public void inorderWalk(){
        inorderWalk(m_root);
    }

    private void postOrderWalk(Node root){
        if (root == null){
            return;
        }

        postOrderWalk(root.m_leftChild);
        postOrderWalk(root.m_rightChild);
        System.out.print(root.m_value+ ", ");
    }

    public void postOrderWalk(){
        postOrderWalk(m_root);
    }

    private void delete(Node root, int key){
        Node parernt = null;
        Node current = m_root;
        while (current != null && current.m_value != key){
            parernt = current;
        
            if (key < current.m_value){
                current = current.m_leftChild;
            }
            else {
            current = current.m_rightChild;
            }
        }
        if (current == null){
            return ;
        } 

        if (current.m_leftChild == null && current.m_rightChild == null){
            if (current != root){
                if (parernt.m_leftChild == current){
                    parernt.m_leftChild = null;
                }
                else {
                    parernt.m_rightChild = null;
                }
            }
            else {
                root = null;
            }
        }

        else if (current.m_leftChild != null && current.m_rightChild != null) {
            Node s = minimum(current.m_rightChild);
            int v = s.m_value;
            delete(root, s.m_value);
            current.m_value = v;
        }

        else {
            Node child;
            if (current.m_leftChild != null) {
                child = current.m_leftChild;
            }
            else {
                child = current.m_rightChild;
            }
            if (current != root){
                if (current == parernt.m_leftChild){
                    parernt.m_leftChild = child;
                }
                else {
                    parernt.m_rightChild = child;
                }
            }
            else {
                root = child;
            }
        }
        return;
    }

    public void deleteValue(int key){
        delete(m_root, key);
    }


}
