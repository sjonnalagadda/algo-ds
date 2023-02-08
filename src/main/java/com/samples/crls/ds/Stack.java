package com.samples.crls.ds;

public class Stack {

    private int[] elements;
    private int top;

    Stack(int size) {
        this.elements = new int[size];
        this.top = -1;
    }

    void push(int element) {
        if(this.top == this.elements.length -1) {
            throw new RuntimeException("Stack is full");
        }
        this.top++;
        this.elements[this.top] = element;
    }

    private boolean empty() {
        if(this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    int pop() {
        if(empty()) {
            throw new RuntimeException("Stack is empty");
        }
        int element = this.elements[this.top];
        this.top--;
        return element;
    }
}
