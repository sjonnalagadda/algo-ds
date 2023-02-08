package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDoubleLinkedList {

    @Test
    public void testAdd() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        Assertions.assertEquals(1, doubleLinkedList.search(1));
        Assertions.assertEquals(3, doubleLinkedList.search(3));
        Assertions.assertEquals(2, doubleLinkedList.search(2));
        Assertions.assertThrows(RuntimeException.class, () -> doubleLinkedList.search(4));
        doubleLinkedList.printList();
    }

    @Test
    public void testDelete() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        Assertions.assertEquals(1, doubleLinkedList.delete(1));
        Assertions.assertEquals(2, doubleLinkedList.delete(2));
        Assertions.assertEquals(3, doubleLinkedList.delete(3));
        Assertions.assertThrows(RuntimeException.class, () -> doubleLinkedList.delete(4));
    }

    @Test
    public void testPredecessor() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        Assertions.assertThrows(RuntimeException.class, () -> doubleLinkedList.predecessor(3));
        Assertions.assertEquals(3, doubleLinkedList.predecessor(2));
        Assertions.assertEquals(2, doubleLinkedList.predecessor(1));
    }

    @Test
    public void testSuccessor() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        Assertions.assertThrows(RuntimeException.class, () -> doubleLinkedList.successor(1));
        Assertions.assertEquals(2, doubleLinkedList.successor(3));
        Assertions.assertEquals(1, doubleLinkedList.successor(2));
    }

    @Test
    public void testReverse() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.printList();
        doubleLinkedList.reverse();
        doubleLinkedList.printList();
    }
}
