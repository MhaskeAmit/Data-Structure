package DoublyLinkedList;

public class DoublyLL {

    public Node head;
    public Node tail;

    public int length;

    public DoublyLL(int value) {
        Node newNode = new Node(value);
        head = tail = newNode;
        length++;
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = tail = newNode;
            length++;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
        length++;
    }

    public void removeLast(){
        if(head == null){
            return;
        }
        Node dummy = tail;
        if(tail != null){
            tail = tail.prev;
            tail.next = null;
        }
        length++;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = tail = newNode;
            length++;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }
    public void removeFirst(){
        if(head == null){
         return;
        }
        head.next.prev = null;
        head = head.next;
        length--;
    }
    public Node get(int index){
        if(index < 0 || index > length){
            return null;
        }
        Node temp = head;
        if(index < length++){

            for(int i=0;i<index;i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i = length-1;i>0;i--){
                temp = temp.prev;
            }
        }
        return temp;
    }
    public void set(int index, int value){
        if(length == 0){
            return;
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        temp.value = value;
    }
    public boolean insert(int index,int value){
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after =  before.next;

        newNode.next = after;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;

    }

    public boolean remove(int index){
        if(length == 0){
            return false;
        }
        if(index == 0){
            removeFirst();
            return true;
        }
        if(index == length){
            removeLast();
            return true;
        }
        Node removeNode = get(index);
        removeNode.next.prev = removeNode.prev;
        removeNode.prev.next = removeNode.next;
        removeNode.next = null;
        removeNode.prev = null;
        length--;
        return true;

    }
    public void swapFirstLast(){
        if(length >=2){
            int temp = head.value;
            head.value = tail.value;
            tail.value = temp;
        }
    }
    public void swap(Node first,Node last){
        if(length >=2){
            int temp = first.value;
            first.value = last.value;
            last.value = temp;
        }
    }

    public void reverse(){
        Node currentNode = head;
        Node tempNode = null;

        while(currentNode.next!=null){
            tempNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = tempNode;
            currentNode = currentNode.prev;
        }
        tempNode = head;
        head = tail;
        tail = tempNode;
    }
    public boolean isPalindrome(){
        Node current = head;
        Node last = tail;

        for(int i=0; i<length/2;i++){
            if(current.value != last.value){
                return false;
            }
            current = current.next;
            last = last.prev;
        }
        return true;
    }
    public void swapPairs(){
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while(head!=null && head.next!=null){
            Node firstNode = head;
            Node secondNode = head.next;
            prev = secondNode.prev;
            firstNode.prev = secondNode;
            if(firstNode.next!=null){
                firstNode.next.prev = firstNode;
            }
            head = firstNode.next;
            prev = firstNode;
        }
        head = dummy.next;
        if(head!=null){
            head.prev = null;
        }


    }
    public void printList(){
        Node current = head;
        System.out.print(current.value+" <=>");
        while(current.next!=null){
            current = current.next;
            System.out.print(current.value+" <=>");
        }
        System.out.println("NULL");
    }
}
