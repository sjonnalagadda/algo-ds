package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCircularQueue {

    @Test
    public void testCircularQueue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        Assertions.assertThrows(RuntimeException.class, () -> circularQueue.enqueue(4));
    }

    @Test
    public void testDequeue() {
        CircularQueue circularQueue = new CircularQueue(3);
        Assertions.assertThrows(RuntimeException.class, () -> circularQueue.dequeue());
    }

    @Test
    public void testEnqueueDequeue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);

        Assertions.assertEquals(1, circularQueue.dequeue());
        Assertions.assertEquals(2, circularQueue.dequeue());
        Assertions.assertEquals(3, circularQueue.dequeue());

        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);

        Assertions.assertEquals(4, circularQueue.dequeue());
        Assertions.assertEquals(5, circularQueue.dequeue());
        Assertions.assertEquals(6, circularQueue.dequeue());
        Assertions.assertThrows(RuntimeException.class, () -> circularQueue.dequeue());
    }

    @Test
    public void testEnqueue() {
        QueueSll queueSll = new QueueSll();
        queueSll.enqueue(1);
        queueSll.enqueue(2);
        queueSll.enqueue(3);
        Assertions.assertEquals(1, queueSll.dequeue());
        Assertions.assertEquals(2, queueSll.dequeue());
        Assertions.assertEquals(3, queueSll.dequeue());
        Assertions.assertThrows(RuntimeException.class, () -> queueSll.dequeue());
    }


    @Test
    public void testEnqueueCqDll() {
        CqDll cqDll = new CqDll();
        cqDll.enqueue(1);
        cqDll.enqueue(2);
        cqDll.enqueue(3);
        Assertions.assertEquals(1, cqDll.dequeue());
        Assertions.assertEquals(2, cqDll.dequeue());
        Assertions.assertEquals(3, cqDll.dequeue());
        Assertions.assertThrows(RuntimeException.class, () -> cqDll.dequeue());
    }
}
