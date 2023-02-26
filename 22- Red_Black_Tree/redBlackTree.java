package com.algorithms;

public class redBlackTree {
    private class RedBlackNode{
        
        private RedBlackNode rightChild, leftChild, parent;
        private int data, color;
        public RedBlackNode(int element, RedBlackNode rightChild, RedBlackNode leftChild){
            this.data = element;
            this.rightChild = rightChild;
            this.leftChild = leftChild;
            this.color = BLACK;
        }
        public RedBlackNode(int data){
            this.data = data;
        }
        public RedBlackNode getRightChild(){
            return this.rightChild;
        }
        public RedBlackNode getLeftChild(){
            return this.leftChild;
        }
        public RedBlackNode getParent(){
            return this.parent;
        }
        public int getData(){
            return this.data;
        }
        public int getColor(){
            return this.color;
        }
        public void setParent(RedBlackNode rightChild){
            this.parent = parent;
        }
        public void setRightChild(RedBlackNode rightChild){
            this.rightChild = rightChild;
        }
        public void setLeftChild(RedBlackNode leftChild){
            this.leftChild = leftChild;
        }  
    }
    
    private RedBlackNode root;
    private static final int RED = 0;
    private static final int BLACK = 1;

    public redBlackTree() {
        root = new RedBlackNode(0);
        root.leftChild = root.rightChild = null;
    }
    public void redBlackTree(RedBlackNode root) {
        this.root = root;
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setParent(null);
        root.color = BLACK;
    }
    // insert Node Red-Black Tree
    public void insert(int inputValue){
        RedBlackNode newNode = new RedBlackNode(inputValue);
        RedBlackNode currentNode = root;
        RedBlackNode tempNode = null;
        while(currentNode != null){
            tempNode = currentNode;
            if(inputValue < currentNode.getData()){
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        newNode.setParent(tempNode);
        if(tempNode == null){
            root = newNode;
            root.setLeftChild(null);
            root.setRightChild(null);
        } else {
              if(newNode.getData() < tempNode.getData()){
                    tempNode.setLeftChild(newNode);
                } else {
                    tempNode.setRightChild(newNode);
                }
            newNode.setLeftChild(null);
            newNode.setRightChild(null);
            newNode.color = RED;
            if(newNode.parent != null)
                addFixTree(newNode);
        }  
    }
    private void addFixTree(RedBlackNode inputNode) {
        inputNode.color = RED;
        while (inputNode != root && inputNode != null && inputNode.getParent().getColor() == RED) {
            if (parent_Of(inputNode) == leftChild_Of(parent_Of(parent_Of(inputNode)))) {
                RedBlackNode tempNode = rightChild_Of(parent_Of(parent_Of(inputNode)));
                if (color_Of(tempNode) == RED) {
                    setColor(parent_Of(inputNode), BLACK);
                    setColor(parent_Of(parent_Of(inputNode)), RED);
                    setColor(tempNode, BLACK);
                    inputNode = parent_Of(parent_Of(inputNode));
                } else {
                    if (rightChild_Of(parent_Of(inputNode)) == inputNode) {
                        inputNode = parent_Of(inputNode);
                        rotationWithLeftChild(parent_Of(inputNode));
                    }
                    setColor(parent_Of(inputNode), BLACK);
                    setColor(parent_Of(parent_Of(inputNode)), RED);
                    rotationWithRightChild(parent_Of(parent_Of((inputNode))));
                }
            } else {
                RedBlackNode temp = leftChild_Of(parent_Of(parent_Of(inputNode)));
                if (color_Of(temp) == RED) {
                    setColor(parent_Of(inputNode), BLACK);
                    setColor(parent_Of(parent_Of(inputNode)), RED);
                    setColor(temp, BLACK);
                    inputNode = parent_Of(parent_Of(inputNode));
                } else {
                    if (leftChild_Of(parent_Of(inputNode)) == inputNode) {
                        inputNode = parent_Of(inputNode);
                        rotationWithRightChild(parent_Of(inputNode));
                    }
                    setColor(parent_Of(inputNode), BLACK);
                    setColor(parent_Of(parent_Of(inputNode)), RED);
                    rotationWithLeftChild(parent_Of(parent_Of((inputNode))));
                }
            }
        }
        root.color = BLACK;
    }
    // delet Node Red-Black Tree
    public void remove(int inputValue){
		RedBlackNode value = searchNode(inputValue);
		RedBlackNode tempNode_1 = null;
		RedBlackNode tempNode_2 = null;

		if (value.getLeftChild() == null || value.getRightChild() == null){
            tempNode_2 = value;
        } else {
            tempNode_2 = treeDeputy(value);
        }
	    if (tempNode_2.getLeftChild() != null) {
            tempNode_1 = tempNode_2.getLeftChild();
        } else {
            tempNode_1 = tempNode_2.getRightChild();
        }

		tempNode_1.parent = tempNode_2.parent;
		if (tempNode_2.parent == null) {
			root = tempNode_1;
        } else if (tempNode_2.parent.getLeftChild() != null && tempNode_2.parent.getLeftChild() == tempNode_2) {
            tempNode_2.parent.leftChild = tempNode_1;
        } else if (tempNode_2.parent.getRightChild() != null && tempNode_2.parent.getRightChild() == tempNode_2) {
            tempNode_2.parent.rightChild = tempNode_1;
        }
		if (tempNode_2 != value){
			value.data = tempNode_2.getData();
		}

		fixNode_Data(tempNode_1,tempNode_2);
		if (tempNode_2.color == BLACK)
            deleteFixTree(tempNode_1);
	}
	private void fixNode_Data(RedBlackNode inpurNode1, RedBlackNode inpurNode2){
		RedBlackNode currentNode = null;
		RedBlackNode tempNode = null;
		if (inpurNode1 == null){
			currentNode = inpurNode2.parent;
			tempNode= inpurNode2;
		} else {
			currentNode = inpurNode1.parent;
			tempNode = inpurNode1;
		}
	}
	private int deleteFixTree(RedBlackNode newNode){
		RedBlackNode node;
		while (newNode.color == BLACK && newNode != root){
			if (newNode.getParent().getLeftChild() == newNode){
				node = newNode.getParent().getRightChild();
				if (node.color == RED){
					node.color = BLACK;
					newNode.parent.color = RED;
					rotationWithLeftChild(newNode.getParent());
					node = newNode.getParent().getRightChild();
				}
				if (node.rightChild.color == BLACK && node.getLeftChild().color == BLACK){
					node.color = RED;
					newNode = newNode.getParent();
				} else {
					if (node.getRightChild().color == BLACK){
						node.getLeftChild().color = BLACK;
						node.color = RED;
						rotationWithRightChild(node);
						node = newNode.getParent().getRightChild();
					}
					node.color = newNode.getParent().getColor();
					newNode.parent.color = BLACK;
					node.getRightChild().color = BLACK;
					rotationWithLeftChild(newNode.getParent());
					newNode = root;
				}
			} else {
				node = newNode.getParent().getLeftChild();
				if (node.color == RED){
					node.color = BLACK;
					newNode.parent.color = RED;
					rotationWithRightChild(newNode.getParent());
					node = newNode.getParent().getLeftChild();
				}
				if (node.getLeftChild().getColor() == BLACK && node.getRightChild().getColor() == BLACK){
                    node.color = RED;
					newNode = newNode.getParent();
				} else {
					if (node.getLeftChild().getColor() == BLACK) {
						node.getRightChild().color = BLACK;
						node.color = RED;
						rotationWithLeftChild(node);
						node = newNode.getParent().getLeftChild();
					}
					node.color = newNode.getParent().getColor();
					newNode.parent.color = BLACK;
					node.getLeftChild().color = BLACK;
					rotationWithRightChild(newNode.getParent());
					newNode = root;
				}
			}
		}
		return newNode.color = BLACK;
	}
    private RedBlackNode treeDeputy(RedBlackNode inputValue){
		if (inputValue.getLeftChild() != null){
            while (inputValue.getRightChild().getLeftChild() != null) {
               return inputValue.rightChild = inputValue.getRightChild().getLeftChild();
            }
            return inputValue.getRightChild();
        }
		RedBlackNode tempNode = inputValue.getParent();
		while (inputValue == tempNode.getRightChild() && tempNode != null){
			inputValue = tempNode;
			tempNode = tempNode.getParent();
		}
		return tempNode;
	}
    //  rotation Node Red-Black Tree
    public void rotationWithLeftChild(RedBlackNode inputNode) {
        if (inputNode != null) {
            RedBlackNode tempNode = inputNode.getRightChild();
            inputNode.setRightChild(tempNode.getLeftChild());
            if (leftChild_Of(tempNode) != null) {
                tempNode.rightChild.parent = inputNode;
            }
            tempNode.setParent(inputNode.getParent());
            if (parent_Of(inputNode) == null) {
                root = tempNode;
            } else if (leftChild_Of(parent_Of(inputNode)) == inputNode) {
                inputNode.parent.leftChild = tempNode;
            } else {
                inputNode.parent.rightChild = tempNode;
            }
            tempNode.setLeftChild(inputNode);
            inputNode.setParent(tempNode);
        }
    }
    public void rotationWithRightChild(RedBlackNode inputNode) {
        if (inputNode != null) {
            RedBlackNode tempNode = inputNode.getLeftChild();
            inputNode.setLeftChild(tempNode.getRightChild());

            if (rightChild_Of(tempNode) != null) {
                tempNode.rightChild.parent = inputNode;
            }
            tempNode.setParent(inputNode.getParent());
            if (parent_Of(inputNode) == null) {
                root = tempNode;
            } else if (rightChild_Of(parent_Of(inputNode)) == inputNode) {
                inputNode.parent.rightChild = tempNode;
            } else {
                inputNode.parent.leftChild = tempNode;
            }
            tempNode.setRightChild(inputNode);
            inputNode.setParent(tempNode);
        }
    }
    private RedBlackNode searchNode(int inputValue){
		RedBlackNode current = root;
		while (current != null){
			if (current.getData() == inputValue) {
				return current;
            } else if (current.getData() < inputValue) {
				current = current.getRightChild();
            } else
				current = current.getLeftChild();
		}
		return null;
	}
    // Tree display
    public void printTree( ) {
        printTree( root.getRightChild() );
    }
    private void printTree(RedBlackNode t) {
        if( t != null ) {
            printTree(t.getLeftChild() );
            System.out.print(t.getData() + ", ");
            printTree( t.getRightChild() );
        }
    }
    
    private RedBlackNode parent_Of(RedBlackNode inputNode) {
        if (inputNode != null)  {return inputNode.getParent();}
        else {return null;}
    }
    private int color_Of(RedBlackNode inputNode) {
        if (inputNode != null)  {return inputNode.getColor();}
        else {return BLACK;}
    }
    private RedBlackNode leftChild_Of(RedBlackNode inputNode) {
        if (inputNode != null)  {return inputNode.getLeftChild();}
        else {return null;}
    }
    private RedBlackNode rightChild_Of(RedBlackNode inputNode) {
        if (inputNode != null)  {return inputNode.getRightChild();}
        else {return null;}
    }
    public void setColor(RedBlackNode inputNode, int color){
        if (inputNode != null) 
            inputNode.color = color;
    }
    public RedBlackNode getRoot(){
        return this.root;
    }
}