package com.samples.crls;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDryMaxPriorityQueue {

    @Test
    public void testMaxPriorityQueue() {
        DArayMaxPriorityQueue dArayMaxPriorityQueue = new DArayMaxPriorityQueue(3);
        dArayMaxPriorityQueue.maxHeapInsert(1);
        dArayMaxPriorityQueue.maxHeapInsert(2);
        dArayMaxPriorityQueue.maxHeapInsert(3);
        dArayMaxPriorityQueue.maxHeapInsert(4);
        dArayMaxPriorityQueue.maxHeapInsert(7);
        dArayMaxPriorityQueue.maxHeapInsert(8);
        dArayMaxPriorityQueue.maxHeapInsert(9);
        dArayMaxPriorityQueue.maxHeapInsert(10);
        dArayMaxPriorityQueue.maxHeapInsert(14);
        dArayMaxPriorityQueue.maxHeapInsert(16);
        Assertions.assertEquals(16, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(14, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(10, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(9, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(8, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(7, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(4, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(3, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(2, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertEquals(1, dArayMaxPriorityQueue.extractMaximum().get());
        Assertions.assertFalse(dArayMaxPriorityQueue.maximum().isPresent());
    }
}
