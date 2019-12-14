package com.vinay.tree;

public class LevelOrderByRecursion {

    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,13};
        BinaryTree binaryTree = BinaryTreeUtil.insertData(ar);
        int height = BinaryTreeUtil.height(binaryTree);
        System.out.println("Height of Binary Tree " + height);
        spirlLevelOrder(binaryTree, height);
    }

    private static void spirlLevelOrder(BinaryTree binaryTree, int height) {

        boolean ltr = true;
        for (int i = 1; i <= height; i++) {
            printGivenLevel(binaryTree, i, ltr);
            ltr = !ltr;

        }
    }

    private static void printGivenLevel(BinaryTree binaryTree, int i, boolean ltr) {

        if (binaryTree == null)
            return;
        if (i == 1)
            System.out.print(binaryTree.getData() + " ");
        if (ltr) {
            printGivenLevel(binaryTree.getLeft(), i - 1, ltr);
            printGivenLevel(binaryTree.getRight(), i - 1, ltr);
        } else {

            printGivenLevel(binaryTree.getRight(), i - 1, ltr);
            printGivenLevel(binaryTree.getLeft(), i - 1, ltr);
        }
    }


}
