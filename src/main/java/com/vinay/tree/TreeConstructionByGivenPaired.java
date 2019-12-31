package com.vinay.tree;

import com.sun.javafx.image.impl.BaseIntToByteConverter;

public class TreeConstructionByGivenPaired {

    public static void main(String[] args) {

        int ar[][] = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}};

        BinaryTree root = new BinaryTree(ar[0][0]);
        root.setLeft(new BinaryTree(ar[0][1]));
        for (int i = 1; i < ar.length; i++) {
            addNodeToTreeUtil(root, ar[i][0], ar[i][1]);
        }
        BST.inorder(root);
    }

    private static void addNodeToTreeUtil(BinaryTree root, int v1, int v2) {
        if (root != null) {
            if (root.getData() == v1) {
                if (root.getLeft() == null)
                    root.setLeft(new BinaryTree(v2));
                else
                    root.setRight(new BinaryTree(v2));
            } else {
                addNodeToTreeUtil(root.left, v1, v2);
                addNodeToTreeUtil(root.right, v1, v2);
            }
        }
    }
}
