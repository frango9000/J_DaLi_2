package org.example.domain.bst;

import java.util.Collection;

public interface Tree<E> extends Collection<E> {
    boolean search(E e);

    boolean insert(E e);

    boolean delete(E e);

    void inorder();

    void postorder();

    void preorder();

    int getSize();

    @Override
    default boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    default int size() {
        return getSize();
    }


    @Override
    default boolean contains(Object o) {
        return search((E) o);
    }

    @Override
    default boolean add(E e) {
        return insert(e);
    }


    @Override
    default boolean remove(Object o) {
        return delete((E) o);
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    default boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) modified = true;
        }
        return modified;
    }

    @Override
    default boolean removeAll(Collection<?> c) {

        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) modified = true;
        }
        return modified;
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (!remove(o)) modified = true;
        }
        return modified;
    }

    @Override
    default Object[] toArray() {
        return null;
    }

    @Override
    default <T> T[] toArray(T[] a) {
        return null;
    }
}
