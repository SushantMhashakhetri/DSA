package linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    class ListNode{
        private int data;
        private ListNode previous;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void insert(int data) {

        ListNode newNode = new ListNode(data);
        if(isEmpty()) {
            this.head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;


    }

    public void printForward() {

        if (head == null) {
            return;
        }
        ListNode temp = head;
        while(temp!= null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printReverse(){
        if (tail == null) {
            return;
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.previous;
        }
        System.out.println("null");

    }

    public void insertAtBeginning(int value){
        ListNode newNode = new ListNode((value));
        if(isEmpty()) {
            tail = newNode;
        } else {
          head.previous = newNode;
            newNode.next = head;
        }

        head = newNode;
    }

    public void insertAtEnd(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.next =newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public ListNode deletefirstNode(){
        if(isEmpty()){
         throw new NoSuchElementException();
        } else {
            ListNode temp = head;
            if(head == tail){
                tail = null;

            } else {
               head.next.previous = null;

            }
            head = head.next;
            temp.next = null;
            length--;
            return temp;
        }
    }

    public ListNode deleteLastNode(){
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            ListNode temp = tail;
            if(head == tail){
                head = null;

            } else {
                tail.previous.next = null;

            }
            tail = tail.previous;
            temp.previous = null;
            length--;
            return temp;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(1);
//        dll.insert(2);
//        dll.insert(4);
//        dll.insert(4);
//        dll.insert(5);
//        dll.insertAtBeginning(56);
//        dll.insertAtEnd(666);
//        dll.deletefirstNode();
        dll.deleteLastNode();
        dll.printForward();
//        dll.printReverse();

    }
}
