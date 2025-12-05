package linkedlist;

public class SinglyLinkedList {

    private ListNode head;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public void printLinkedList() {
        if(head == null) {
            System.out.println("null");
        }
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode fetchNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value");
        }
        ListNode maintPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than no of nodes in list");
            }
            count++;
            refPtr = refPtr.next;
        }
        while(refPtr != null) {
            refPtr = refPtr.next;
            maintPtr = maintPtr.next;
        }
        return  maintPtr;
    }

    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }
        ListNode temp = null;
        ListNode current = head;
        while( current != null && current.data < value ) {
            temp = current;
            current = current.next;

        }
        newNode.next = current;
        temp.next = newNode;
        return  head;
    }

    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return  true;
            }
        }
        return false;
    }

    public ListNode getStartNodeOfLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return  getCommonNode(slowPtr);
            }
        }
        return null;
    }

    public ListNode getCommonNode(ListNode node) {
        ListNode temp = head;
        while(temp != null && temp != node) {
            temp = temp.next;
            node = node.next;
        }
        return  temp;
    }

    public void removeLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                removeCommonNode(slowPtr);
                return;
            }
        }
    }

    public void removeCommonNode(ListNode slowPtr) {
        ListNode headPtr = head;
        while (headPtr.next != slowPtr.next) {
            headPtr = headPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public void createLoop() {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = sixth;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.insertAtBeginning(1);
//        sll.insertAtBeginning(2);
//        sll.insertAtBeginning(3);

//        sll.insertAtEnd(1);
//        sll.insertAtEnd(2);
//        sll.insertAtEnd(3);
//        sll.insertAtEnd(4);
//        sll.insertAtEnd(5);


//        System.out.println(sll.fetchNodeFromEnd(10).data);
//        sll.insertInSortedList(3);
//        sll.insertInSortedList(4);
//        sll.insertInSortedList(36);
//        sll.printLinkedList();

//        sll.createLoop();
////        sll.printLinkedList();
//        System.out.println(sll.containsLoop());
//        System.out.println(sll.getStartNodeOfLoop().data);
//        sll.removeLoop();
//        sll.printLinkedList();

    }



}
