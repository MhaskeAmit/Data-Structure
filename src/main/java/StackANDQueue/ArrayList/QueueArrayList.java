package StackANDQueue.ArrayList;

import java.util.ArrayList;
import java.util.Stack;

public class QueueArrayList<T> {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public QueueArrayList(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value){

        while(!stack1.isEmpty()){
            int val1 = stack1.pop();
            stack2.push(val1);
        }
        stack1.push(value);
        while(!stack2.isEmpty()){
            int val2 = stack2.pop();
            stack1.push(val2);
        }

    }
    public Integer dequeue(){
        int value;
        if(stack1.isEmpty()){
            return null;
        }else{
            value = stack1.pop();
        }
        return value;
    }
}
