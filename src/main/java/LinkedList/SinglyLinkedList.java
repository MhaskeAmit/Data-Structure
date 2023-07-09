package LinkedList;

import java.util.HashSet;

public class SinglyLinkedList {

    public Node head;
    public Node tail;
    public int length;

    public SinglyLinkedList(int value){
        Node newNode = new Node(value);
        head = tail = newNode;
        length++;

    }
    public void isEmpty(){
        head = tail = null;
        length = 0;
    }


    public void append(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
            length++;
        }
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
        length++;
    }
    public int removeLast(){
        if(length==0){
            return 0;
        }
        Node temp = head;
        Node prev = head;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if(length==0){
            head = tail = null;
        }
        return temp.value;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = tail = newNode;
        }
        newNode.next = head;
        head = newNode;
    }
    public int removeFirst(){
        Node current = head;
        if(length == 0){
            return 0;
        }
        head = current.next;
        current.next = null;
        return current.value;
    }
    public Node get(int index){
        if(index < 0 || index > length){
            return null;
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        System.out.println(temp.value);
        return temp;
    }
    public void set(int index,int value){
        if(index < 0 || index > length){
            return;
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        temp.value = value;
    }
    public boolean insert(int index,int value){
        if(index < 0 ){
            return false;
        }
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    public boolean remove(int index){
        if(index < 0){
            return false;
        }
        if(index == 0){
            removeFirst();
            return true;
        }
        if(index == length-1){
            removeLast();
            return true;
        }
        Node SpecificIndex = get(index-1);
        Node temp = SpecificIndex.next;
        SpecificIndex.next = temp.next;
        temp.next = null;
        length--;
        return true;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0; i<length;i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public Node findMiddleNode(){

        Node fast = head;
        Node slow = head;

        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean hasLoop(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public Node findKthNode(int k){
        Node slow = head;
        Node fast = head;

        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public void reverseBetween(int m , int n){
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for(int i = 0 ; i < m ; i++){
            prev = prev.next;
        }
        Node current = prev.next;
        for(int j=0;j<n-m;j++){
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        head = dummy.next;

    }
    public void partitionList(int x){
        Node current = head;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        while(current!=null){
            if(current.value < x){
                prev1.next = current;
                prev1 = current;
            }else{
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }

    public void removeDuplicates(){
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        Node current = head;

        while(current!=null){
            if(set.contains(current.value)){
                prev.next = current.next;
            }else{
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }
    public void printList(){
        System.out.println("Print LinkedList");
        Node current = head;
        System.out.print(current.value+" ->");
        while(current.next!=null){
            current = current.next;
            System.out.print(current.value+" ->");
        }
        System.out.println("NULL");
    }
}
