package DoublyLinkedList;

public class Main {
    public static void main(String args[]){
        DoublyLL dl= new DoublyLL(1);
        dl.append(20);
        dl.append(4);
        dl.removeLast();
        dl.prepend(100);
        dl.removeFirst();
        dl.set(1,123);
        dl.insert(1,55);
        dl.remove(1);
        //dl.swapFirstLast();
        dl.reverse();
        dl.printList();
    }
}
