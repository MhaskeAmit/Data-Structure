package StackANDQueue.ArrayList;

public class Main {
    public static void main(String args[]){
        StackArrayList sa = new StackArrayList();

        sa.push(10);
        sa.push(20);
        sa.push(30);
        sa.printStack();
        sa.reverse();
        sa.printStack();
        System.out.println(sa.reverseString("Amit"));
        System.out.println(sa.balancedParanthesis("((((((((((((())))))"));
    }
}
