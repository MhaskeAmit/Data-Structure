package StackANDQueue.ArrayList;

import java.util.ArrayList;
import java.util.Stack;

public class StackArrayList<T> {

    public ArrayList<T> st = new ArrayList<>();

    public ArrayList<T> getStackList(){
        return st;
    }

    public void printStack(){
        for(int i=st.size()-1;i>=0;i--){
            System.out.println(st.get(i));
        }
    }
    public void push(T value){
        st.add(value);
    }
    public void pop(){
        st.remove(st.size()-1);
    }

    public void reverse(){
        for(int i=0;i<=st.size()-1;i++){
            System.out.println("Reverse stack ::"+st.get(i));
        }
    }
    public String reverseString(String value){
         char ch;
         String reverse = "";
         for(int i=0;i<value.length();i++){
             ch = value.charAt(i);
             reverse = ch + reverse;
         }
         return reverse;
    }

    public boolean balancedParanthesis(String paranthesis){
        Stack<Character> par = new Stack<>();

        for(char ch : paranthesis.toCharArray()){
            if(ch=='('){
                System.out.println("Pusing (");
                par.push(ch);
            }else if(ch==')'){
                if(par.isEmpty() || par.pop()!='('){
                    return false;
                }
            }
        }
        return par.isEmpty();
    }
}
