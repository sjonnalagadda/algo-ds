package com.samples.crls.ds;

public class SingleLinkedList {

    private DSNode head;

    SingleLinkedList() {
        this.head = null;
    }

    private void checkEmpty() {
        if(this.head == null) {
            throw new RuntimeException("List is empty.");
        }
    }

    void add(int value) {
        DSNode dsNode = new DSNode(value);
        if(this.head == null) {
            this.head = dsNode;
        } else {
            dsNode.next = this.head;
            this.head = dsNode;
        }
    }

    int search(int x) {
        checkEmpty();
        DSNode current = this.head;
        while(current != null) {
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
        DSNode previous = this.head;
        while(current != null) {
            //Only for root nodes
            if(current.value == x && current == this.head) {
                this.head = current.next;
                return current.value;
            } else if(current.value == x) { // For remaining nodes
                previous.next = current.next;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        throw new RuntimeException("Element not found");
    }

    void printList() {
        checkEmpty();
        DSNode current = this.head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    int predecessor(int x) {
        checkEmpty();
        DSNode current = this.head;
        DSNode previous = this.head;
        while(current != null) {
            //Only for root nodes
            if(current.value == x && current == this.head) {
                throw new RuntimeException("No predecessor");
            } else if(current.value == x) { // For remaining nodes
                return previous.value;
            }
            previous = current;
            current = current.next;
        }
        throw new RuntimeException("Element not found");
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
        DSNode previous = this.head;
        DSNode current = previous.next;
        previous.next = null;
        while(current != null) {
            DSNode temp = current;
            current = temp.next;
            temp.next = previous;
            previous = temp;
        }
        this.head = previous;
    }
}
