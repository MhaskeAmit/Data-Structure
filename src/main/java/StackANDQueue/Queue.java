package StackANDQueue;

public class Queue {
    private Node first;
    private Node last;

    private int length;
    public Queue(int value){
        first = last = new Node(value);
        length++;
    }

    public void Enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = last  = newNode;
        }
        last.next = newNode;
        last = newNode;
        length++;
    }
    public void dequeue(){
        if(length==0){
            return;
        }
        if(length == 1){
            first = null;
            last = null;
        }
        if(length>1){
            first = first.next;
        }
        length--;
    }
    public void printList(){
        if(length==0){
            System.out.println("EMPTY");
        }else{
            System.out.println("Queue");
            Node temp = first;
            while(temp!=null){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }
}
