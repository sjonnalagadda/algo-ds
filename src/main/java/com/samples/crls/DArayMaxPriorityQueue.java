package com.samples.crls;

import java.util.Optional;

public class DArayMaxPriorityQueue {

    private static final int INITIAL_CAPACITY = 3;

    private int[] queue;
    private int heapSize;
    private int numberOfChildren;

    public DArayMaxPriorityQueue(int numberOfChildren) {
        this.queue = new int[INITIAL_CAPACITY];
        this.numberOfChildren = numberOfChildren;
        this.heapSize = 0;
    }

    public int getParent(int childIndex) {
        return (childIndex - 1) / this.numberOfChildren;
    }

    public int getChildStart(int parentIndex) {
        return this.numberOfChildren * parentIndex + 1;
    }

    public int getChildEnd(int parentIndex) {
        return this.numberOfChildren * parentIndex +
                this.numberOfChildren;
    }

    public Optional<Integer> maximum() {
        if(this.heapSize == 0) {
            return Optional.empty();
        } else {
            return Optional.of(this.queue[0]);
        }
    }

    public void maxHeapInsert(int value) {
        if(this.heapSize == this.queue.length) {
            //Time to make expand array
            int newQueueSize = queue.length + INITIAL_CAPACITY;
            int[] newQueue = new int[newQueueSize];
            System.arraycopy(this.queue, 0, newQueue, 0, this.queue.length);
            this.queue = newQueue;
        }
        this.heapSize++;
        this.queue[heapSize -1] = Integer.MIN_VALUE;
        heapIncreaseKey(this.heapSize, value);
    }

    public void heapIncreaseKey(int heapIndex, int value) {
        if(heapIndex > this.heapSize) {
            throw new IllegalStateException(String.format("The heap size is smaller than the heap index %d", heapIndex));
        }
        if(this.queue[heapIndex -1] >= value) {
            throw new IllegalArgumentException(
                    String.format("The value %d passed should be greater than current value at that index %d", value,
                            heapIndex));
        }
        this.queue[heapIndex -1] = value;
        //Restore max heap property
        int index = heapIndex -1;
        while(index > 0 && this.queue[getParent(index)]  < this.queue[index]) {
            //swap
            int temp = this.queue[getParent(index)];
            this.queue[getParent(index)] = this.queue[index];
            this.queue[index] = temp;
            index = getParent(index);
        }
    }

    public Optional<Integer> extractMaximum() {
        if(this.heapSize == 0) {
            return Optional.empty();
        } else {
            //Get first element
            int maximumElement = this.queue[0];
            //Get last last element and put it at the top of the heap.
            this.queue[0] = this.queue[this.heapSize -1];
            //To make things clean let's reset to zero
            this.queue[this.heapSize -1] = 0;
            //Reduce heap size
            this.heapSize--;
            //Call heapify on first element
            this.maxHeapify(0);
            return Optional.of(maximumElement);
        }
    }

    public boolean delete(int entry) {
        int heapIndex = -1;
        for(int index = 0; index < this.queue.length; index++) {
            if(this.queue[index] == entry) {
                heapIndex = index;
            }
        }
        //Found an entry. Need to delete it.
        if(heapIndex != -1) {
            deleteInternal(heapIndex);
            return true;
        } else {
            return false;
        }

    }

    public void deleteInternal(int heapIndex) {
        if(heapIndex > this.heapSize) {
            throw new IllegalStateException(String.format("The heap size is smaller than the heap index %d", heapIndex));
        }
        if(heapIndex == this.heapSize -1){
            //Just tidy up the things.
            this.queue[this.heapSize -1] = 0;
            this.heapSize--;
        } else {
            //swap with last element of the heap with element at current heap index that need to deleted.
            int entryToBeDeleted = this.queue[heapIndex];
            this.queue[heapIndex] = this.queue[heapSize -1];
            //Restore max heap property. Shift-down
            this.maxHeapify(heapIndex);
            //if the element did't bubble down, then try bubbling up
            if(entryToBeDeleted == this.queue[heapIndex]) {
                while(heapIndex > 0 && this.queue[getParent(heapIndex)]  > this.queue[heapIndex]) {
                    //swap
                    int temp = this.queue[getParent(heapIndex)];
                    this.queue[getParent(heapIndex)] = this.queue[heapIndex];
                    this.queue[heapIndex] = temp;
                    heapIndex = getParent(heapIndex);
                }
            }
            //Just tidy up the things.
            this.queue[this.heapSize -1] = 0;
            //To make things clean let's reset to zero
            this.heapSize--;
        }
    }

    private void maxHeapify(int nodeIndex) {
        int childFirstIndex =  getChildStart(nodeIndex);
        int childLastIndex = getChildEnd(nodeIndex);
        int largestIndex = nodeIndex;

        //Find biggest child value
        for(int index = childFirstIndex; index <= childLastIndex; index++) {
            if(index < this.heapSize && this.queue[index] > this.queue[largestIndex]) {
                largestIndex = index;
            }
        }
        if(largestIndex != nodeIndex) {
            //Swap
            int temp = this.queue[nodeIndex];
            this.queue[nodeIndex] = this.queue[largestIndex];
            this.queue[largestIndex] = temp;
            //Call max-heapify to make sure all the nodes with new parent index satisfy max-heapify propery
            maxHeapify(largestIndex);
        }
    }
}
