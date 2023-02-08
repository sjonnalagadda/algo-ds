package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMaxPriorityQueue {

    @Test
    public void testInsertion() {
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue();
        maxPriorityQueue.maxHeapInsert(1);
        maxPriorityQueue.maxHeapInsert(2);
        maxPriorityQueue.maxHeapInsert(3);
        maxPriorityQueue.maxHeapInsert(4);
        maxPriorityQueue.maxHeapInsert(7);
        maxPriorityQueue.maxHeapInsert(8);
        maxPriorityQueue.maxHeapInsert(9);
        maxPriorityQueue.maxHeapInsert(10);
        maxPriorityQueue.maxHeapInsert(14);
        maxPriorityQueue.maxHeapInsert(16);
        Assertions.assertEquals(16, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(14, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(10, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(9, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(8, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(7, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(4, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(3, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(2, maxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(1, maxPriorityQueue.extractMaximum().get());
        Assertions.assertFalse(maxPriorityQueue.maximum().isPresent());
    }

    @Test
    public void testDeletion() {
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue();
        maxPriorityQueue.maxHeapInsert(1);
        maxPriorityQueue.maxHeapInsert(2);
        maxPriorityQueue.maxHeapInsert(3);
        maxPriorityQueue.maxHeapInsert(4);
        maxPriorityQueue.maxHeapInsert(7);
        maxPriorityQueue.maxHeapInsert(8);
        maxPriorityQueue.maxHeapInsert(9);
        maxPriorityQueue.maxHeapInsert(10);
        maxPriorityQueue.maxHeapInsert(14);
        maxPriorityQueue.maxHeapInsert(16);
        Assertions.assertTrue(maxPriorityQueue.delete(2));
    }
}
