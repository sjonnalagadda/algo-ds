package com.samples.crls.ds;

/**
 * Circular queue using double linked list
 */
public class CqDll {

    private DSNode sentinel;

    CqDll() {
        this.sentinel = new DSNode();
        sentinel.prev = sentinel.next = this.sentinel;
    }

    void enqueue(int x) {
        DSNode dsNode = new DSNode(x);
        //It means empty
        if(this.sentinel.prev == this.sentinel &&  this.sentinel.next == this.sentinel) {
            this.sentinel.next = dsNode;
            this.sentinel.prev = dsNode;
            dsNode.prev = this.sentinel;
            dsNode.next = this.sentinel;
        } else { // For appending at the front
            this.sentinel.prev.prev = dsNode;
            dsNode.next = this.sentinel.prev;
            dsNode.prev = this.sentinel;
            this.sentinel.prev = dsNode;
        }
    }

    int dequeue() {
        //That means there no elements in the queue
        if (this.sentinel.prev == this.sentinel &&  this.sentinel.next == this.sentinel) {
            throw new RuntimeException("Queue is empty");
        } else {
           //Element to be removed
           DSNode aNode =  this.sentinel.next;
           //There is only one node.
           if(aNode.prev == this.sentinel) {
               sentinel.prev = sentinel.next = this.sentinel;
           } else {
               aNode.prev.next = this.sentinel;
               this.sentinel.next = aNode.prev;
           }
           return aNode.value;
        }
    }
}
