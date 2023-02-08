package com.samples.crls.ds;

public class QueueSll {

    private DSNode head;
    private DSNode tail;

    QueueSll() {
        this.head = null;
        this.tail = null;
    }

    void enqueue(int x) {
        DSNode aNode = new DSNode(x);
        if(this.head == null && this.tail == null) {
            this.tail = aNode;
            this.head = aNode;
        } else {
            this.head.next = aNode;
            this.head = aNode;
        }
    }

    int dequeue() {
        if (this.head == null && this.tail == null) {
            throw new RuntimeException("Queue is empty");
        }
        int element = this.tail.value;
        if(this.head == this.tail) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = this.tail.next;
        }
        return element;
    }
}
