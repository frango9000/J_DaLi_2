package org.example.domain.bst;

public class TreeNode<E> {

    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }

    public E getElement() {
        return element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setElement(E e) {
        element = e;
    }

    public void setLeft(TreeNode<E> newLeft) {
        left = newLeft;
    }

    public void setRight(TreeNode<E> newRight) {
        right = newRight;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public boolean isInternal() {
        return (left != null) || (right != null);
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
}
