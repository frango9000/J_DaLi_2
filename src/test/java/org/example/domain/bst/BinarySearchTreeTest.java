package org.example.domain.bst;

import org.junit.jupiter.api.Test;

import static org.example.support.Generators.getRandomArray;
import static org.example.support.Generators.getUniqueRandom;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {

    @Test
    void should_create_a_binary_search_tree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertEquals(0, tree.getSize());
    }

    @Test
    void should_create_a_binary_search_tree_with_elements() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(getUniqueRandom(50));
        assertEquals(50, tree.getSize());
    }

    @Test
    void should_add_an_element_to_the_tree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        assertEquals(1, tree.getSize());
    }

    @Test
    void should_add_multiple_elements_to_the_tree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        assertEquals(10, tree.getSize());
    }

    @Test
    void should_remove_an_element_from_the_tree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.remove(1);
        assertEquals(9, tree.getSize());
    }

    @Test
    void should_remove_multiple_elements_from_the_tree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.remove(1);
        tree.remove(2);
        tree.remove(3);
        tree.remove(4);
        tree.remove(5);
        tree.remove(6);
        tree.remove(7);
        tree.remove(8);
        tree.remove(9);
        tree.remove(10);
        assertEquals(0, tree.getSize());
    }


    @Test
    void search() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(getRandomArray(50));
        tree.add(500000);
        assertTrue(tree.search(500000));
    }
}
