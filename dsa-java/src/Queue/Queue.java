package Queue;

import linkedlist.SinglyLinkedList;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;

    }
   private class ListNode {
        private int data;
        private ListNode next;
        public ListNode (int data){
            this.data = data;
            this.next = null;
        }
    }
     public int length() {
            return length;
     }

     public boolean isEmpty() {
         return length ==0;
     }

     public void enque(int data) {
         ListNode temp = new ListNode(data);
         if(isEmpty()) {
             front = temp;
         } else {
             rear.next = temp;
         }
         rear = temp;
         length++;
     }

     public int dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;

            }
            length--;
            return data;
        }
     }

    public void print() {
        if(front == null) {
            System.out.println("null");
        }
        ListNode current = front;
        while(current != null){
            System.out.print(current.data + "<--");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
       Queue queue = new Queue();
       queue.enque(2);
       queue.enque(5);
       queue.enque(9);
       queue.dequeue();
       queue.print();

    }
}
