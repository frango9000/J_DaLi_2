package org.example.domain.bst;

import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    public AVLTree() {
    }

    public AVLTree(E[] objects) {
        super(objects);
    }

    @Override
    protected TreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        boolean inserted = super.insert(e);
        if (!inserted) {
            return false;
        }
        balancePath(e);
        return true;
    }

    @Override /* Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */ public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else break;
        }

        if (current == null) return false;

        // Case 1: current has no left children
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) parent.left = current.right;
                else parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
            balancePath(parentOfRightMost.element);
        }

        size--;
        return true;
    }

    private void updateHeight(AVLTreeNode<E> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            node.height = 0;
        } else if (node.getLeft() == null) {
            node.height = 1 + ((AVLTreeNode<E>) node.getRight()).height;
        } else if (node.getRight() == null) {
            node.height = 1 + ((AVLTreeNode<E>) node.getLeft()).height;
        } else {
            node.height = 1 + Math.max(((AVLTreeNode<E>) node.getRight()).height, ((AVLTreeNode<E>) node.getLeft()).height);
        }
    }

    private void balancePath(E e) {
        ArrayList<TreeNode<E>> path = path(e);

        for (int i = path.size() - 1; i >= 0; i--) {
            AVLTreeNode<E> a = (AVLTreeNode<E>) path.get(i);
            updateHeight(a);
            AVLTreeNode<E> parentOfA = a == root ? null : ((AVLTreeNode<E>) path.get(i - 1));

            switch (balanceFactor(a)) {
                case -2:
                    if (balanceFactor((AVLTreeNode<E>) a.getLeft()) <= 0) balanceLL(a, parentOfA);
                    else balanceLR(a, parentOfA);
                case 2:
                    if (balanceFactor((AVLTreeNode<E>) a.getRight()) >= 0) balanceRR(a, parentOfA);
                    else balanceRL(a, parentOfA);
            }
        }
    }

    private int balanceFactor(AVLTreeNode<E> node) {
        if (node.getRight() == null) {
            return -node.height;
        } else if (node.getLeft() == null) {
            return +node.height;
        } else {
            return ((AVLTreeNode<E>) node.getLeft()).height - ((AVLTreeNode<E>) node.getRight()).height;
        }
    }


    private void balanceLL(TreeNode<E> a, TreeNode<E> parentOfA) {
        TreeNode<E> b = a.getLeft();
        if (root == a) {
            root = b;
        } else {
            if (a == parentOfA.getLeft()) {
                parentOfA.setLeft(b);
            } else {
                parentOfA.setRight(b);
            }
        }
        a.setLeft(b.getRight());
        b.setRight(a);
        updateHeight((AVLTreeNode<E>) a);
        updateHeight((AVLTreeNode<E>) b);
    }

    private void balanceLR(TreeNode<E> a, TreeNode<E> parentOfA) {
        TreeNode<E> b = a.getLeft();
        TreeNode<E> c = b.getRight();

        if (a == root) {
            root = c;
        } else {
            if (a == parentOfA.getLeft()) {
                parentOfA.setLeft(c);
            } else {
                parentOfA.setRight(c);
            }
        }

        a.setLeft(c.getRight());
        b.setRight(c.getLeft());
        c.setLeft(b);
        c.setRight(a);

        updateHeight((AVLTreeNode<E>) a);
        updateHeight((AVLTreeNode<E>) b);
        updateHeight((AVLTreeNode<E>) c);
    }

    private void balanceRR(TreeNode<E> a, TreeNode<E> parentOfA) {
        TreeNode<E> b = a.getRight();
        if (root == a) {
            root = b;
        } else {
            if (a == parentOfA.getLeft()) {
                parentOfA.setLeft(b);
            } else {
                parentOfA.setRight(b);
            }
        }
        a.setRight(b.getLeft());
        b.setLeft(a);
        updateHeight((AVLTreeNode<E>) a);
        updateHeight((AVLTreeNode<E>) b);
    }

    private void balanceRL(TreeNode<E> a, TreeNode<E> parentOfA) {
        TreeNode<E> b = a.getRight();
        TreeNode<E> c = b.getLeft();

        if (a == root) {
            root = c;
        } else {
            if (a == parentOfA.getLeft()) {
                parentOfA.setLeft(c);
            } else {
                parentOfA.setRight(c);
            }
        }

        a.setRight(c.getLeft());
        b.setLeft(c.getRight());
        c.setLeft(a);
        c.setRight(b);

        updateHeight((AVLTreeNode<E>) a);
        updateHeight((AVLTreeNode<E>) b);
        updateHeight((AVLTreeNode<E>) c);
    }
}
