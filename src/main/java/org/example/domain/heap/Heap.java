package org.example.domain.heap;

public interface Heap<E extends Comparable<E>> {
    void add(E newObject);

    E remove();

    int getSize();


}

