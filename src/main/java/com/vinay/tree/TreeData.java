package com.vinay.tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeData {
    static BinaryTree binaryTree = new BinaryTree(1, null, null);

    static {


        binaryTree.left = new

                BinaryTree(2, null, null);

        binaryTree.right = new

                BinaryTree(3, null, null);

        binaryTree.left.left = new

                BinaryTree(4, null, null);

        binaryTree.left.right = new

                BinaryTree(5, null, null);

        binaryTree.right.left = new

                BinaryTree(6, null, null);

        binaryTree.right.right = new

                BinaryTree(7, null, null);
    }
}
