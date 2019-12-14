package com.vinay.tree;

import java.util.Stack;

public class CountSumIntoBST {

    public static void main(String[] args) {

        BST bst1 = new BST();
        bst1.insert(5);
        bst1.insert(3);
        bst1.insert(7);
        bst1.insert(2);
        bst1.insert(4);
        bst1.insert(6);
        bst1.insert(8);
        bst1.inorder(bst1.root);
        System.out.println();
        BST bst2 = new BST();
        bst2.insert(10);
        bst2.insert(6);
        bst2.insert(15);
        bst2.insert(3);
        bst2.insert(8);
        bst2.insert(11);
        bst2.insert(18);
        bst2.inorderReverse(bst2.root);
        System.out.println();

        int c = count(bst1.root, bst2.root, 16);
        System.out.println(c);


    }

    private static int count(BinaryTree root, BinaryTree root1, int i) {

        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        int count = 0;
        while (true) {
            while (root != null) {

                stack1.push(root);
                root = root.getLeft();
            }

            while (root1 != null) {

                stack2.push(root1);
                root1 = root1.getRight();
            }

            if (stack1.isEmpty() || stack2.isEmpty())
                break;
            BinaryTree top1 = stack1.peek();
            BinaryTree top2 = stack2.peek();


            if ((top1.getData() + top2.getData()) == i) {
                count++;
                stack1.pop();
                stack2.pop();
                root = top1.getRight();
                root1 = top2.getLeft();
            } else if ((top1.getData() + top2.getData()) > i) {
                root1 = top2.getLeft();
                stack2.pop();
            } else {
                root = top1.getRight();
                stack1.pop();
            }
        }
        return count;
    }
}
