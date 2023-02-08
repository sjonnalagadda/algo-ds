package com.samples.crls.ds;

public class CircularQueue {

    private int[] elements;
    private int head;
    private int tail;

    CircularQueue(int size) {
        this.elements = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    private boolean full() {
          //  when no element is de-queued and all the slots are filled
          if( this.head == 0 && this.tail == this.elements.length -1) {
              return true;
              //When tail pointer is behind
          } else if(this.head == this.tail + 1) {
              return true;
          } else {
              return false;
          }
    }

    private boolean empty() {
        if(this.head == -1) {
            return true;
        }
        return false;
    }

    void enqueue(int element) {
        if(full()) {
            throw new RuntimeException("Queue is full");
        }
        if (this.head == -1) {
            this.head = 0;
        }
        this.tail = (this.tail + 1) % this.elements.length;
        this.elements[this.tail] = element;
    }

    int dequeue() {
        if(empty()) {
            throw new RuntimeException("Queue is empty");
        }
        int element = this.elements[this.head];
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.elements.length;
        }
        return element;
    }
}
