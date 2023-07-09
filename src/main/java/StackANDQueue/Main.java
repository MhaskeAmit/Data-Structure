package StackANDQueue;

public class Main {
    public static void main(String args[]){
//        Stack st = new Stack(1);
//        st.push(2);
//        st.push(3);
//        System.out.println("POP ::"+st.pop().value);
//        st.printValue();
        Queue q = new Queue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        q.Enqueue(4);
        q.dequeue();
        q.printList();
    }
}
