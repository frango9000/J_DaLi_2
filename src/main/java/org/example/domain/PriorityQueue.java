package org.example.domain;

import org.example.domain.heap.ArrayHeap;
import org.example.domain.heap.Heap;

import java.util.Comparator;

public class PriorityQueue<E extends Comparable<E>> {
    private Heap<E> heap = new ArrayHeap<>();

    public PriorityQueue() {
    }

    public PriorityQueue(Comparator<E> comparator) {
        heap = new ArrayHeap<>(comparator);
    }

    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }
}
