package linkedlist;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode tail;
    private  int length;

    class ListNode{
        private int data;
        private ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    private int length(){
        return length;
    }

    public boolean isEmpty(){

            return length == 0;

    }

    CircularSinglyLinkedList(){
        this.tail = null;
        length = 0;
    }

    // insert at beginning
    public void insertNode(int data) {
        ListNode temp = new ListNode(data);
        if(tail == null){
            tail = temp;

        } else {

            temp.next = tail.next;
        }
        tail.next = temp;
        length++;

    }
    public void insertAtEnd(int data) {
        ListNode temp = new ListNode(data);
        if(tail == null){
            tail = temp;
            tail.next = temp;
        } else {
//            ListNode first = tail.next;
//            temp.next = first;
//            tail.next = temp;
//            tail = temp;

            temp.next = tail.next;
            tail.next = temp;
            tail = temp;

        }

        length++;
    }

    public ListNode removeFirstNode() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode first = tail.next;
        if(tail.next == tail) {
            tail = null;
        } else {
        tail.next = first.next;
        }
        first.next = null;

        length --;
        return first;
    }

    public void printList(){
        if(tail == null){
            throw  new NoSuchElementException();
        }
        ListNode first = tail.next;

        while(first != tail){
            System.out.print(first.data +"-->");
            first = first.next;

        }
        System.out.println(first.data);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insertNode(10);
        csll.insertNode(15);
        csll.insertAtEnd(16);
        ListNode first = csll.removeFirstNode();
        csll.printList();
        System.out.println(first.data);

    }
}
