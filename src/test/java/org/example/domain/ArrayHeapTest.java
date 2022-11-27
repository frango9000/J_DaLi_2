package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayHeapTest {

    @Test
    void should_create_a_heap_in_an_array() {
        ArrayHeap<Integer> heap = new ArrayHeap<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertEquals(10, heap.getSize());
    }

    @Test
    void should_add_an_element_to_the_heap() {
        ArrayHeap<Integer> heap = new ArrayHeap<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        heap.add(11);
        assertEquals(11, heap.getSize());
    }

    @Test
    void should_heap_sort_an_array() {
        Integer[] listToSort = getRandomArray(500);

        ArrayHeap.heapSort(listToSort);

        for (int i = 0; i < listToSort.length - 1; i++) {
            assertTrue(listToSort[i] <= listToSort[i + 1]);
        }

    }

    @Test
    void should_remove_an_element_from_the_heap() {
        ArrayHeap<Integer> heap = new ArrayHeap<>(getRandomArray(50));
        heap.remove();
        assertEquals(49, heap.getSize());
    }

    private Integer[] getRandomArray(int size) {
        Random rand = new Random(); //instance of random class
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) list.add(rand.nextInt(size));
        Collections.shuffle(list);
        return list.toArray(new Integer[0]);
    }
}
