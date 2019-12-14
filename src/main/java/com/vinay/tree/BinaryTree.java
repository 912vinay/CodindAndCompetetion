package com.vinay.tree;

public class BinaryTree {

    private int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
