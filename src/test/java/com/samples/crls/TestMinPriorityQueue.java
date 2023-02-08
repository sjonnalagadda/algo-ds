package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TestMinPriorityQueue {

    @Test
    public void testInsertion() {
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue();
        minPriorityQueue.minHeapInsert(16);
        minPriorityQueue.minHeapInsert(14);
        minPriorityQueue.minHeapInsert(10);
        minPriorityQueue.minHeapInsert(9);
        minPriorityQueue.minHeapInsert(8);
        minPriorityQueue.minHeapInsert(7);
        minPriorityQueue.minHeapInsert(4);
        minPriorityQueue.minHeapInsert(3);
        minPriorityQueue.minHeapInsert(2);
        minPriorityQueue.minHeapInsert(1);
        Assertions.assertEquals(1, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(2, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(3, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(4, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(7, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(8, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(9, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(10, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(14, minPriorityQueue.extractMinimum().get());
        Assertions.assertEquals(16, minPriorityQueue.extractMinimum().get());
        Assertions.assertFalse(minPriorityQueue.minimum().isPresent());
    }

    @Test
    public void testDeletion() {
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue();
        minPriorityQueue.minHeapInsert(16);
        minPriorityQueue.minHeapInsert(14);
        minPriorityQueue.minHeapInsert(10);
        minPriorityQueue.minHeapInsert(9);
        minPriorityQueue.minHeapInsert(8);
        minPriorityQueue.minHeapInsert(7);
        minPriorityQueue.minHeapInsert(4);
        minPriorityQueue.minHeapInsert(3);
        minPriorityQueue.minHeapInsert(2);
        minPriorityQueue.minHeapInsert(1);
        Assertions.assertTrue(minPriorityQueue.delete(2));
        System.out.println("log");
    }

    @Test
    public void testDeletion2() {
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue();
        minPriorityQueue.minHeapInsert(10);
        minPriorityQueue.minHeapInsert(3);
        minPriorityQueue.minHeapInsert(15);
        minPriorityQueue.minHeapInsert(2);
        minPriorityQueue.minHeapInsert(7);
        minPriorityQueue.minHeapInsert(11);
        minPriorityQueue.minHeapInsert(12);
        minPriorityQueue.minHeapInsert(13);
        minPriorityQueue.minHeapInsert(2);
        minPriorityQueue.minHeapInsert(2);
        minPriorityQueue.minHeapInsert(6);
        minPriorityQueue.minHeapInsert(8);
        minPriorityQueue.minHeapInsert(1);
        minPriorityQueue.minHeapInsert(5);
        minPriorityQueue.minHeapInsert(1);
        Assertions.assertEquals(1, minPriorityQueue.extractMinimum().get());
        Assertions.assertTrue(minPriorityQueue.delete(12));
        Assertions.assertTrue(minPriorityQueue.delete(3));
        Assertions.assertEquals(1, minPriorityQueue.extractMinimum().get());
        Assertions.assertTrue(minPriorityQueue.delete(6));
    }

    @Test
    public void testKWayMerge() {
        List a = new LinkedList<Integer>();
        for(int i=0; i<10; i++) {
            a.add(i);
        }
        List b = new LinkedList<Integer>();
        for(int i=10; i<25; i++) {
            b.add(i);
        }

        List c = new LinkedList<Integer>();
        for(int i=25; i<30; i++) {
            c.add(i);
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        lists.add(c);

        Comparator<DataIndexNode> dataIndexNodeComparator = new Comparator<DataIndexNode>() {
            @Override
            public int compare(DataIndexNode a, DataIndexNode b) {
                if (a.data > b.data) {
                    return 1;
                } else if(a.data == b.data) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        PriorityQueue<DataIndexNode> priorityQueue = new PriorityQueue<>(dataIndexNodeComparator);

        for(int i = 0; i < lists.size(); i++) {
            final List<Integer> list = lists.get(i);
            priorityQueue.add(new DataIndexNode(list.get(0), i));
            list.remove(0);
        }

        List<Integer> mergedList = new LinkedList<>();

        while(!priorityQueue.isEmpty()) {
            DataIndexNode dataIndexNode = priorityQueue.remove();
            mergedList.add(dataIndexNode.getData());
            if(!lists.get(dataIndexNode.index).isEmpty()) {
                final List<Integer> list = lists.get(dataIndexNode.index);
                priorityQueue.add(new DataIndexNode(list.get(0), dataIndexNode.index));
                list.remove(0);
            }
        }

        System.out.println(mergedList);
    }
}
