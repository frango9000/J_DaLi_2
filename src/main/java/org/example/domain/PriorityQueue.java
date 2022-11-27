package org.example.domain;

public class PriorityQueue<E extends Comparable<E>> {
    private final Heap<E> heap = new ArrayHeap<>();

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
