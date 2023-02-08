package com.samples.crls;

import java.util.Optional;

public class MaxPriorityQueue {

    private static final int INITIAL_CAPACITY = 3;

    private int[] queue;
    private int heapSize;

    public MaxPriorityQueue() {
        queue = new int[INITIAL_CAPACITY];
        heapSize = 0;
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

    public Optional<Integer> maximum() {
        if(this.heapSize == 0) {
            return Optional.empty();
        } else {
            return Optional.of(this.queue[0]);
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
        while(index > 0 && this.queue[parent(index)]  < this.queue[index]) {
            //swap
            int temp = this.queue[parent(index)];
            this.queue[parent(index)] = this.queue[index];
            this.queue[index] = temp;
            index = parent(index);
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

    private void deleteInternal(int heapIndex) {
        if(heapIndex > this.heapSize) {
            throw new IllegalStateException(String.format("The heap size is smaller than the heap index %d", heapIndex));
        }
        //Last element
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
                while(heapIndex > 0 && this.queue[parent(heapIndex)]  < this.queue[heapIndex]) {
                    //swap
                    int temp = this.queue[parent(heapIndex)];
                    this.queue[parent(heapIndex)] = this.queue[heapIndex];
                    this.queue[heapIndex] = temp;
                    heapIndex = parent(heapIndex);
                }
            }
            //Just tidy up the things.
            this.queue[this.heapSize -1] = 0;
            //To make things clean let's reset to zero
            this.heapSize--;
        }
    }

    private void maxHeapify(int nodeIndex) {
        int leftChildIndex =  left(nodeIndex);
        int rightChildIndex = right(nodeIndex);
        int largestIndex = nodeIndex;

        //We should be within bounds of heap and if left child is greater than parent
        if (leftChildIndex < this.heapSize && this.queue[leftChildIndex] > this.queue[nodeIndex]) {
            largestIndex = leftChildIndex;
        }
        //We should be within bounds of heap and if right child is greater than parent
        if (rightChildIndex < this.heapSize && this.queue[rightChildIndex] > this.queue[largestIndex]) {
            largestIndex = rightChildIndex;
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

    private static int left(int parentIndex) {
        return 2 * parentIndex;
    }

    private static int right(int parentIndex) {
        return left(parentIndex) + 1;
    }

    private static int parent(int nodeIndex) {
        return (nodeIndex) / 2;
    }
}
