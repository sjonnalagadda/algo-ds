package com.samples.crls.ds;

public class DoubleLinkedList {

    private DSNode head;

    DoubleLinkedList() {
        this.head = null;
    }

    private void checkEmpty() {
        if(this.head == null) {
            throw new RuntimeException("List is empty.");
        }
    }

    void add(int value) {
        DSNode aNode = new DSNode(value);
        if(this.head == null) {
            this.head = aNode;
        } else {
            aNode.next = head;
            head.prev = aNode;
            head = aNode;
        }
    }

    int search(int x) {
        checkEmpty();
        DSNode current = this.head;
        while(current != null){
            if(current.value == x) {
                return current.value;
            }
            current = current.next;
        }
        throw new RuntimeException("Element not found");
    }

    int delete(int x) {
        checkEmpty();
        DSNode current = this.head;
        while(current != null) {
            if(current.value == x && current == this.head) {
                if(current.next != null) {
                    current.next.prev = null;
                }
                this.head = current.next;
                return current.value;
            } else  if (current.value == x){
                current.prev.next = current.next;
                if(current.next != null) {
                    current.next.prev = current.prev;
                }
                return current.value;
            }
            current = current.next;
        }
        throw new RuntimeException("Element not found");
    }

    void printList() {
        checkEmpty();
        DSNode current = this.head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }

    }

    int predecessor(int x) {
        checkEmpty();
        DSNode current = this.head;
        while(current != null) {
            if(current.value == x && current == this.head) {
                throw new RuntimeException("No predecessor");
            } else  if (current.value == x){
              return current.prev.value;
            }
            current = current.next;
        }
        return 0;
    }

    int successor(int x) {
        checkEmpty();
        DSNode current = this.head;
        while(current != null) {
            //Only for root nodes
            if(current.value == x && current.next == null) {
                throw new RuntimeException("No Successor. End node");
            } else if(current.value == x) { // For remaining nodes
                return current.next.value;
            }
            current = current.next;
        }
        throw new RuntimeException("Element not found");
    }

    void reverse() {
        checkEmpty();
        DSNode current = this.head.next;
        DSNode previous = this.head;
        previous.next = null;
        while (current != null) {
            DSNode temp = current;
            current = current.next;
            temp.next = previous;
            temp.next.prev = temp;
            previous = temp;
        }
        this.head = previous;
    }
}
