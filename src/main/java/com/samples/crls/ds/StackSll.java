package com.samples.crls.ds;

public class StackSll {

    private DSNode head;

    StackSll() {
        this.head = null;
    }

    void push(int x) {
        DSNode aNode = new DSNode(x);
        if(this.head == null) {
            this.head = aNode;
        } else {
            aNode.next = this.head;
            this.head = aNode;
        }
    }

    int pop() {
       if(this.head == null) {
           throw new RuntimeException("Stack is empty");
       }
       int value = this.head.value;
       this.head = this.head.next;
       return value;
    }
}
