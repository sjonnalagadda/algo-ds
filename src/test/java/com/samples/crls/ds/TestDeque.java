package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class TestDeque {

    @Test
    public void testDequeAsCircularQueue() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        utilDeque.addFirst(1);
        utilDeque.addFirst(2);
        utilDeque.addFirst(3);
        Assertions.assertThrows(RuntimeException.class, ()-> deque.addFirst(4));

        Assertions.assertEquals(3, deque.removeFirst());
        Assertions.assertEquals(2, deque.removeFirst());
        Assertions.assertEquals(1, deque.removeFirst());

        Assertions.assertEquals(3, utilDeque.removeFirst());
        Assertions.assertEquals(2, utilDeque.removeFirst());
        Assertions.assertEquals(1, utilDeque.removeFirst());

        Assertions.assertThrows(RuntimeException.class, ()-> deque.removeFirst());

    }

    @Test
    public void testAddingLastAndRemovingLast() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        utilDeque.addLast(1);
        utilDeque.addLast(2);
        utilDeque.addLast(3);
        Assertions.assertThrows(RuntimeException.class, ()-> deque.addLast(4));

        Assertions.assertEquals(3, deque.removeLast());
        Assertions.assertEquals(2, deque.removeLast());
        Assertions.assertEquals(1, deque.removeLast());

        Assertions.assertEquals(3, utilDeque.removeLast());
        Assertions.assertEquals(2, utilDeque.removeLast());
        Assertions.assertEquals(1, utilDeque.removeLast());

        Assertions.assertThrows(RuntimeException.class, ()-> deque.removeLast());
    }


    @Test
    public void addFirstAndRemoveLast() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        utilDeque.addFirst(1);
        utilDeque.addFirst(2);
        utilDeque.addFirst(3);
        Assertions.assertThrows(RuntimeException.class, ()-> deque.addFirst(4));

        Assertions.assertEquals(1, deque.removeLast());
        Assertions.assertEquals(2, deque.removeLast());
        Assertions.assertEquals(3, deque.removeLast());

        Assertions.assertEquals(1, utilDeque.removeLast());
        Assertions.assertEquals(2, utilDeque.removeLast());
        Assertions.assertEquals(3, utilDeque.removeLast());

        Assertions.assertThrows(RuntimeException.class, ()-> deque.removeLast());
    }

    @Test
    public void addLastAndRemoveFirst() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        utilDeque.addLast(1);
        utilDeque.addLast(2);
        utilDeque.addLast(3);
        Assertions.assertThrows(RuntimeException.class, ()-> deque.addLast(4));

        Assertions.assertEquals(1, deque.removeFirst());
        Assertions.assertEquals(2, deque.removeFirst());
        Assertions.assertEquals(3, deque.removeFirst());

        Assertions.assertEquals(1, utilDeque.removeFirst());
        Assertions.assertEquals(2, utilDeque.removeFirst());
        Assertions.assertEquals(3, utilDeque.removeFirst());

        Assertions.assertThrows(RuntimeException.class, ()-> deque.removeLast());
    }

    @Test
    public void addAndRemoveOneByOne() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        utilDeque.addFirst(1);
        utilDeque.addFirst(2);
        utilDeque.addFirst(3);
        Assertions.assertEquals(1, deque.removeLast());
        Assertions.assertEquals(1, utilDeque.removeLast());
        deque.addFirst(4);
        utilDeque.addFirst(4);
        Assertions.assertEquals(2, deque.removeLast());
        Assertions.assertEquals(2, utilDeque.removeLast());
        deque.addFirst(5);
        utilDeque.addFirst(5);
        Assertions.assertEquals(3, deque.removeLast());
        Assertions.assertEquals(3, utilDeque.removeLast());
        deque.addFirst(6);
        utilDeque.addFirst(6);
        Assertions.assertEquals(4, deque.removeLast());
        Assertions.assertEquals(4, utilDeque.removeLast());
        deque.addFirst(7);
        utilDeque.addFirst(7);
        Assertions.assertEquals(5, deque.removeLast());
        Assertions.assertEquals(5, utilDeque.removeLast());
        Assertions.assertEquals(6, deque.removeLast());
        Assertions.assertEquals(6, utilDeque.removeLast());
        Assertions.assertEquals(7, deque.removeLast());
        Assertions.assertEquals(7, utilDeque.removeLast());

        Assertions.assertThrows(RuntimeException.class, ()-> deque.removeLast());
    }


    @Test
    public void testSize() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        utilDeque.addFirst(1);
        utilDeque.addFirst(2);
        utilDeque.addFirst(3);
        Assertions.assertEquals(3, deque.size());
        Assertions.assertEquals(3, utilDeque.size());
    }

    @Test
    public void testSizeZero() {
        Deque deque = new Deque(3);
        java.util.Deque utilDeque = new ArrayDeque();
        Assertions.assertEquals(0, deque.size());
        Assertions.assertEquals(0, utilDeque.size());
    }

    @Test
    public void testSizeWhenAddingAtEnd() {
        Deque deque = new Deque(3);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        java.util.Deque utilDeque = new ArrayDeque();
        utilDeque.addLast(1);
        utilDeque.addLast(2);
        utilDeque.addLast(3);
        Assertions.assertEquals(3, deque.size());
        Assertions.assertEquals(3, utilDeque.size());
    }

    @Test
    public void testWhenAddingAtEnd() {
        Deque deque = new Deque(3);
        deque.addLast(1);
        deque.addLast(2);
        java.util.Deque utilDeque = new ArrayDeque();
        utilDeque.addLast(1);
        utilDeque.addLast(2);
        Assertions.assertEquals(2, deque.size());
        Assertions.assertEquals(2, utilDeque.size());
    }

    @Test
    public void testWhenNotFullAnd() {
        Deque deque = new Deque(4);
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(3);
        java.util.Deque utilDeque = new ArrayDeque();
        utilDeque.addLast(1);
        utilDeque.addLast(2);
        utilDeque.addFirst(3);
        Assertions.assertEquals(3, deque.size());
        Assertions.assertEquals(3, utilDeque.size());
    }

}
