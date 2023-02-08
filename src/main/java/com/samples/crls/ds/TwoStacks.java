package com.samples.crls.ds;

public class TwoStacks {

    private int[] elements;
    private int lsIdx;
    private int hsIdx;
    private int size;


    TwoStacks(int size) {
        this.elements = new int[size];
        this.size = size;
        this.lsIdx = -1;
        this.hsIdx = size;
    }

    boolean isFull() {
        if (this.hsIdx - this.lsIdx == 1) {
            return true;
        }
        return false;
    }

    void pushIntoLower(int element) {
        if(isFull()) {
            throw new RuntimeException("Storage is full");
        }
        this.lsIdx++;
        this.elements[this.lsIdx] = element;

    }

    void pushIntoHigher(int element) {
        if(isFull()) {
            throw new RuntimeException("Storage is full");
        }
        this.hsIdx--;
        this.elements[this.hsIdx] = element;
    }

    int popFromLower() {
        if(this.lsIdx == -1) {
            throw new RuntimeException("Lower Stack is Empty");
        }
        int element = this.elements[this.lsIdx];
        this.lsIdx--;
        return element;
    }

    int popFromHigher() {
        if(this.lsIdx == this.size) {
            throw new RuntimeException("Higher Stack is Empty");
        }
        int element = this.elements[this.hsIdx];
        this.hsIdx++;
        return element;
    }
}
