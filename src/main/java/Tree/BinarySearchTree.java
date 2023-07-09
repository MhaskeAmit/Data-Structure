package Tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
        root = null;
    }
    public Node getRoot(){
        return root;
    }

    public boolean insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;

        while(temp!=null){
            if(newNode.value == temp.value){
                return false;
            }
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }

            if(newNode.value > temp.value){
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.left;
            }

        }
    return false;
    }

    public boolean contains(int value){
        if(root == null){
            return false;
        }
        Node temp = root;
        while(temp!=null){
            if(temp.value > value){
                temp = temp.left;
            }
            if(temp.value < value){
                temp = temp.right;
            }
            if(temp.value == value){
                return true;
            }
        }
        return false;
    }
    public boolean rContains(Node currentNode, int value){
        if(currentNode==null){
            return false;
        }
        if(currentNode.value == value){
            return true;
        }
        if(currentNode.value > value){
            return rContains(currentNode.left,value);
        }
        if(currentNode.value < value){
            return rContains(currentNode.right,value);
        }
        return true;
    }
    public boolean rContains(int value){
        return rContains(root,value);
    }

    public Node rInsert(Node currentNode, int value){
        Node newNode = new Node(value);
        if(currentNode == null){
            currentNode = newNode;
        }
        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left,value);
        }else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right,value);
        }
        return currentNode;
    }

    public void rInsert(int value){
        rInsert(root,value);
    }
}
