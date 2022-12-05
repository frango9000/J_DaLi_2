package org.example.domain.bst;

import org.example.domain.bst.TreeNode;

public class AVLTreeNode<E> extends TreeNode<E> {
    int height;

    public AVLTreeNode(E e) {
        super(e);
    }
}
