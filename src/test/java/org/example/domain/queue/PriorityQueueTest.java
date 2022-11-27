package org.example.domain.queue;

import org.example.domain.PriorityQueue;
import org.example.support.TestEvent;
import org.example.support.TestEventReverseComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriorityQueueTest {

    @Test
    void enqueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        assertEquals(10, queue.getSize());
    }

    @Test
    void dequeue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertEquals(9, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(7, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(0, queue.getSize());
    }


    @Test
    void should_queue_comparable() {
        PriorityQueue<TestEvent> queue = new PriorityQueue<>();
        queue.enqueue(new TestEvent("A", 1));
        queue.enqueue(new TestEvent("B", 2));
        queue.enqueue(new TestEvent("C", 3));
        queue.enqueue(new TestEvent("D", 4));
        queue.enqueue(new TestEvent("E", 5));
        queue.enqueue(new TestEvent("F", 6));
        assertEquals("F", queue.dequeue().getName());
        assertEquals("E", queue.dequeue().getName());
        assertEquals("D", queue.dequeue().getName());
        assertEquals("C", queue.dequeue().getName());
        assertEquals("B", queue.dequeue().getName());
        assertEquals("A", queue.dequeue().getName());
        assertEquals(0, queue.getSize());
    }


    @Test
    void should_create_priority_queue_with_custom_comparator() {
        PriorityQueue<TestEvent> queue = new PriorityQueue<>(new TestEventReverseComparator());
        queue.enqueue(new TestEvent("A", 1));
        queue.enqueue(new TestEvent("B", 2));
        queue.enqueue(new TestEvent("C", 3));
        queue.enqueue(new TestEvent("D", 4));
        queue.enqueue(new TestEvent("E", 5));
        queue.enqueue(new TestEvent("F", 6));
        assertEquals("A", queue.dequeue().getName());
        assertEquals("B", queue.dequeue().getName());
        assertEquals("C", queue.dequeue().getName());
        assertEquals("D", queue.dequeue().getName());
        assertEquals("E", queue.dequeue().getName());
        assertEquals("F", queue.dequeue().getName());
        assertEquals(0, queue.getSize());
    }
}
