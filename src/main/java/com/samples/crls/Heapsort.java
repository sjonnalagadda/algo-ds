package com.samples.crls;

public class Heapsort {

    private static int left(int parentIndex) {
        return 2 * parentIndex;
    }

    private static int right(int parentIndex) {
        return left(parentIndex) + 1;
    }

    private static int parent(int nodeIndex) {
        return nodeIndex / 2;
    }

    public static void maxHeapifyWithoutRecursion(int[] input, int heapSize,  int parentIndex) {
        int largestIndex = parentIndex;
        while(true) {
            int leftChildIndex =  left(parentIndex);
            int rightChildIndex = right(parentIndex);
            //We should be within bounds of heap and if left child is greater than parent
            if (leftChildIndex <= heapSize && input[leftChildIndex -1] > input[parentIndex -1]) {
                largestIndex = leftChildIndex;
            }
            //We should be within bounds of heap and if right child is greater than parent
            if (rightChildIndex <= heapSize && input[rightChildIndex -1] > input[largestIndex -1]) {
                largestIndex = rightChildIndex;
            }
            if(largestIndex != parentIndex) {
                //Swap
                int temp = input[parentIndex -1];
                input[parentIndex -1] = input[largestIndex - 1];
                input[largestIndex - 1] = temp;
                //New parent
                parentIndex = largestIndex;
            }else {
                return;
            }
        }
    }

    public static void maxHeapify(int[] input, int heapSize, int parentIndex) {
        int leftChildIndex =  left(parentIndex);
        int rightChildIndex = right(parentIndex);
        int largestIndex = parentIndex;

        //We should be within bounds of heap and if left child is greater than parent
        if (leftChildIndex <= heapSize && input[leftChildIndex -1] > input[parentIndex -1]) {
            largestIndex = leftChildIndex;
        }
        //We should be within bounds of heap and if right child is greater than parent
        if (rightChildIndex <= heapSize && input[rightChildIndex -1] > input[largestIndex -1]) {
            largestIndex = rightChildIndex;
        }
        if(largestIndex != parentIndex) {
            //Swap
            int temp = input[parentIndex -1];
            input[parentIndex -1] = input[largestIndex - 1];
            input[largestIndex - 1] = temp;
            //Call max-heapify to make sure all the nodes with new parent index satisfy max-heapify propery
            maxHeapify(input, heapSize, largestIndex);
        }
    }

    public static void minHeapify(int[] input, int heapSize, int nodeIndex) {
        int leftChildIndex =  left(nodeIndex);
        int rightChildIndex = right(nodeIndex);
        int smallestIndex = nodeIndex;
        //We should be within bounds of heap and if left child is greater than parent
        if (leftChildIndex <= heapSize && input[leftChildIndex -1] < input[smallestIndex -1]) {
            smallestIndex = leftChildIndex;
        }
        //We should be within bounds of heap and if right child is greater than parent
        if (rightChildIndex <= heapSize && input[rightChildIndex -1] < input[smallestIndex -1]) {
            smallestIndex = rightChildIndex;
        }
        if(smallestIndex != nodeIndex) {
            //Swap
            int temp = input[nodeIndex -1];
            input[nodeIndex -1] = input[smallestIndex - 1];
            input[smallestIndex - 1] = temp;
            int nextParent = parent(nodeIndex);
            if(nextParent != 0) {
                minHeapify(input, heapSize, nextParent);
            }
        }
    }

    public static void buildMaxHeap(int[] input) {
        for(int index = input.length /2 ; index >=1; index--) {
            maxHeapify(input, input.length, index);
        }
    }

    public static void buildMinHeap(int[] input) {
        for(int index = input.length /2 ; index >=1; index--) {
            minHeapify(input, input.length, index);
        }
    }

    public static void heapSort(int[] input) {
        buildMaxHeap(input);
        int heapSize = input.length;
        for(int index = input.length; index >=2; index--) {
            //get input[1] and put it last index
            int temp = input[index -1];
            input[index -1] = input[0];
            input[0] = temp;
            //Reduce the heap size. Because the last element is already in correct place.
            heapSize = heapSize -1;
            //Fix the max heap property
            maxHeapify(input, heapSize, 1);
        }
    }

}
