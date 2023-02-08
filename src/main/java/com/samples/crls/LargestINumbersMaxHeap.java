package com.samples.crls;

public class LargestINumbersMaxHeap {

    private int heapSize;
    private int[] heap;

    LargestINumbersMaxHeap(int[] input) {
        this.heap = input;
        this.heapSize = input.length -1;
        this.buildMaxHeap();
    }

    public int extractMax() {
        if(this.heapSize == -1) {
            throw new IllegalArgumentException("No more elements in the heap");
        }
        int maxElement = this.heap[0];
        this.heap[0] = this.heap[this.heapSize];
        this.heapSize--;
        maxHeapify(0);
        return maxElement;
    }

    private int getParentIdx(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int parentIndex) {
        return (2 * parentIndex) + 1;
    }
    private int rightChild(int parentIndex) {
        return leftChild(parentIndex) + 1;
    }

    private void maxHeapify(int parentIdx) {
        int leftChildIdx = leftChild(parentIdx);
        int rightChildIdx = rightChild(parentIdx);
        int currentIdx = parentIdx;
        if(leftChildIdx <= this.heapSize && this.heap[leftChildIdx] > this.heap[currentIdx]) {
            currentIdx = leftChildIdx;
        }
        if(rightChildIdx <= this.heapSize && this.heap[rightChildIdx] > this.heap[currentIdx]) {
            currentIdx = rightChildIdx;
        }
        if(currentIdx != parentIdx) {
            swap(currentIdx,  parentIdx);
            maxHeapify(currentIdx);
        }
    }

    private void swap(int pos1, int pos2) {
        int temp = this.heap[pos1];
        this.heap[pos1] = this.heap[pos2];
        this.heap[pos2] = temp;
    }

    private void buildMaxHeap() {
        for(int parentIdx = this.heapSize  / 2; parentIdx >= 0; parentIdx--) {
            maxHeapify(parentIdx);
        }
    }
}
