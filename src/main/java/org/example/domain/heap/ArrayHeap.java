package org.example.domain.heap;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayHeap<E extends Comparable<E>> implements Heap<E> {
    private final ArrayList<E> list = new ArrayList<>();
    private Comparator<E> comparator;

    public ArrayHeap() {
    }

    public ArrayHeap(E[] objects) {
        for (E object : objects) add(object);
    }

    public ArrayHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public ArrayHeap(E[] objects, Comparator<E> comparator) {
        this(objects);
        this.comparator = comparator;
    }

    @Override
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else break; // the tree is a heap now

            currentIndex = parentIndex;
        }
    }

    @Override
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else break; // The tree is a heap
        }

        return removedObject;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    public int compare(E o1, E o2) {
        if (comparator != null) {
            return comparator.compare(o1, o2);
        } else {
            return o1.compareTo(o2);
        }
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new ArrayHeap<>(list);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}
