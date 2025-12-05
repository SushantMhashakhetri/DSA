package stack;

import java.util.List;
import java.util.NoSuchElementException;

public class Stack {
    public Stack() {
        this.top = null;
        this.length = 0;
    }

    private int length;
    private ListNode top;

    class ListNode {
        private int data;
        private ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }
    public int pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int temp = top.data;
        top = top.next;
        length--;
        return temp;

    }
    public void printStack() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = top;
        while(temp != null){
            System.out.print(temp.data+ "-->");
            temp = temp.next;

        }
        System.out.println("null");
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return top.data;
    }


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.pop();
        System.out.println(s.peek());
        s.printStack();

    }
}
