package LinkedList;

public class Main {
    public static void main(String args[]){
        SinglyLinkedList sl = new SinglyLinkedList(30);
        sl.append(20);
        sl.append(30);
        sl.append(90);
        sl.printList();
        System.out.println(sl.removeLast());
        sl.prepend(1);
        sl.prepend(2);
        sl.removeFirst();
        sl.get(2);
        sl.set(2,8);
        sl.insert(3,21);
        sl.printList();
        sl.remove(3);
        sl.remove(0);
        Node mid = sl.findMiddleNode();
        System.out.println("Mid val :"+mid.value);
        System.out.println("Has Loop :"+sl.hasLoop());
        System.out.println("kth node :"+ sl.findKthNode(2).value);
//        sl.reverseBetween(0,1);

        sl.printList();
//        sl.partitionList(35);
        sl.removeDuplicates();
        sl.printList();
    }
}
