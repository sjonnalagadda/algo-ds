package com.samples.crls.ds;
/*
 *
 *  addFirst and removeFirst provides LIFO
 *  addLast and removeLast provides LIFO
 *  addFirst and removeLast provides FIFO
 *  addLast and removeFirst provides FIFO
 */
public class Deque {

    private int[] elements;
    private int head;
    private int tail;
    private int size;

    Deque(int size) {
        this.elements = new int[size];
        this.head = -1;
        this.tail = -1;
        this.size = size;
    }

    void addLast(int x) {
        if(this.head == -1 && this.tail == -1) {
            this.head = 0;
            this.tail = 0;
            this.elements[tail] = x;
        } else if((this.tail + 1) % this.size == this.head) {
            throw new RuntimeException("Queue is full");
        } else {
            this.tail = (this.tail + 1) % this.size;
            this.elements[this.tail] = x;
        }
    }

    void addFirst(int x) {
        if(this.head == -1 && this.tail == -1) {
            this.head = 0;
            this.tail = 0;
            this.elements[head] = x;
        } else if(this.head == 0 && this.tail == this.size -1) {
            throw new RuntimeException("Deque is full");
        } else if((this.tail +1) % this.size == this.head) {
            throw new RuntimeException("Deque is full");
        } else if(this.head == 0) {
            this.head = this.size -1;
            this.elements[head] = x;
        } else {
            this.head = this.head -1;
            this.elements[head] = x;
        }
    }

    int removeFirst() {
        int element;
        if(this.head == -1 && this.tail == -1) {
            throw new RuntimeException("Deque is Empty");
        } else if(this.head == this.tail) {
            element = this.elements[this.head];
            this.head = this.tail = -1;
        } else {
            element = this.elements[this.head];
            this.head = (this.head + 1) % this.size;
        }
        return element;
    }

    int removeLast() {
        int element;
        if(this.head == -1 && this.tail == -1) {
            throw new RuntimeException("Deque is Empty");
        } else if (this.head == this.tail) {
            element = this.elements[this.tail];
            this.head = this.tail = -1;
        } else if( this.tail == 0 ) {
            element = this.elements[this.tail];
            this.tail = this.size -1;
        } else {
            element = this.elements[this.tail];
            this.tail = this.tail -1;
        }

        return element;
    }

    int size() {
        if(this.head == -1 && this.tail == -1) {
            return 0;
        } else if((this.head == 0 && this.tail == this.size -1)
                  || ((this.tail +1) % this.size == this.head)) {
            return this.size;
        } else if (head > tail) {
            return this.size - this.head + (this.tail + 1);
        } else {
            return this.tail - this.head + 1;
        }
    }
}
