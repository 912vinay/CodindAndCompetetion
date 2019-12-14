package com.vinay.tree;

import java.util.Stack;

public class BST {

    BinaryTree root;

    public BST() {
        root = null;
    }

    public BinaryTree insert(int data, BinaryTree root) {
        if (root == null) {
            root = new BinaryTree(data);
        } else if (data > root.getData()) {
            root.setRight(insert(data, root.getRight()));
        } else
            root.setLeft(insert(data, root.getLeft()));
        return root;
    }

    public void insert(int data) {
        root = insert(data, root);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(4);
        bst.insert(5);
        bst.insert(0);
        bst.insert(35);
        bst.insert(10);
        bst.insert(3);
        bst.insert(2);
        bst.inorder(bst.root);
        System.out.println();
        bst.delete(1);
        bst.inorder(bst.root);
        System.out.println();
        bst.inorderWithStack(bst.root);
    }

    private void inorderWithStack(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty())
                break;

            BinaryTree top = stack.pop();
            System.out.print(top.getData() + " ");
            root = top.getRight();
        }
    }

    private void delete(int i) {

        root = delete(i, root);
    }

    private BinaryTree delete(int i, BinaryTree root) {

        if (root != null) {
            if (root.getData() == i) {
                if (root.getLeft() == null) {
                    root = root.getRight();
                } else if (root.getRight() == null) {
                    root = root.getLeft();
                } else {
                    int min = minValue(root.getRight());
                    root.setData(min);
                    root.setRight(delete(min, root.getRight()));
                }
            } else if (root.getData() > i) {
                root.setLeft(delete(i, root.getLeft()));
            } else
                root.setRight(delete(i, root.getRight()));
        }
        return root;
    }

    private int minValue(BinaryTree right) {
        int t = right.getData();
        while (right != null) {
            t = right.getData();
            right = right.getLeft();
        }
        return t;
    }


    public void inorder(BinaryTree root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    public void inorderReverse(BinaryTree root) {
        if (root != null) {
            inorderReverse(root.getRight());
            System.out.print(root.getData() + " ");
            inorderReverse(root.getLeft());
        }
    }
}
