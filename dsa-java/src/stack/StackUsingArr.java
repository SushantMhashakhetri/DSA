package stack;

import java.util.NoSuchElementException;

public class StackUsingArr
{
    private int top;
    private int[] arr;

    public StackUsingArr(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int data) {
        if(isFull()) {
        throw new RuntimeException("Stack is full !!");
        }

        arr[++top] = data;


    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty !!");
        }
        return arr[--top];

    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty !!");
        }
        return arr[top];
    }

    public void printStack() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
       for(int a: arr){
           System.out.print(a + "-->");
       }
    }

    public boolean isFull() {
        return arr.length == size();
    }
    public boolean isEmpty() {
        return top < 0;
    }
    public int size() {
        return top+1;
    }

    public static void main(String[] args) {
        StackUsingArr stack = new StackUsingArr(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        System.out.println(stack.peek());

    }
}
