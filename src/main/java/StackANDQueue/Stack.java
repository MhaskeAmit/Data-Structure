package StackANDQueue;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value){
        top = new Node(value);
        height++;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
            height++;
        }
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop(){
        if(height==0){
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void printStack(){
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printValue(){
        if(height==0){
            System.out.println("EMPTY");
        }else{
            System.out.println("TOP :"+top.value);
        }
        System.out.println("Stack :");
        if(height==0){
            System.out.println("EMPTY");
        }else{
            printStack();
        }
    }
}
