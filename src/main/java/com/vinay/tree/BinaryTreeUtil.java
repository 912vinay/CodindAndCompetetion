package com.vinay.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {

    public static BinaryTree insertData(int ar[]) {
        BinaryTree binaryTree = null;
        Queue<BinaryTree> queue = new LinkedList<>();
        int i = 0;
        binaryTree = new BinaryTree(ar[i++]);
        queue.add(binaryTree);
        while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();
            if (temp.getLeft() == null && ar.length > i) {
                temp.setLeft(new BinaryTree(ar[i++]));
                queue.add(temp.getLeft());
            }
            if (temp.getRight() == null && ar.length > i) {
                temp.setRight(new BinaryTree(ar[i++]));
                queue.add(temp.getRight());
            }
        }
        return binaryTree;
    }

    public static int height(BinaryTree node) {
        if (node == null)
            return 0;
        int lheight = height(node.getLeft());
        int rheight = height(node.getRight());
        if (lheight > rheight)
            return (lheight + 1);
        else
            return (rheight + 1);
    }
}
