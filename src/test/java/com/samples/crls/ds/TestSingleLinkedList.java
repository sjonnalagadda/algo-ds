package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSingleLinkedList {

    @Test
    public void printList() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.printList();
    }

    @Test
    public void searchList() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        Assertions.assertEquals(1, singleLinkedList.search(1));
        Assertions.assertEquals(2, singleLinkedList.search(2));
        Assertions.assertEquals(3, singleLinkedList.search(3));
        Assertions.assertEquals(4, singleLinkedList.search(4));
        Assertions.assertEquals(5, singleLinkedList.search(5));
        Assertions.assertThrows(RuntimeException.class, () -> singleLinkedList.search(6));
    }

    @Test
    public void deleteWhenThereIsOneElement() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.printList();
        Assertions.assertEquals(1, singleLinkedList.delete(1));
        singleLinkedList.printList();
        Assertions.assertThrows(RuntimeException.class, () -> singleLinkedList.delete(6));
    }

    @Test
    public void deleteWhenThereIsMoreElements() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.printList();
        Assertions.assertEquals(1, singleLinkedList.delete(1));
        singleLinkedList.printList();
        Assertions.assertThrows(RuntimeException.class, () -> singleLinkedList.delete(6));
    }

    @Test
    public void getSuccessor() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.printList();
        Assertions.assertThrows(RuntimeException.class, () -> singleLinkedList.successor(1));
        Assertions.assertEquals(1, singleLinkedList.successor(2));
        singleLinkedList.printList();
    }

    @Test
    public void getPredecessor() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.printList();
        Assertions.assertThrows(RuntimeException.class, () -> singleLinkedList.predecessor(2));
        Assertions.assertEquals(2, singleLinkedList.predecessor(1));
        singleLinkedList.printList();
    }

    @Test
    public void reverse() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.printList();
        singleLinkedList.reverse();
        singleLinkedList.printList();
    }
}
