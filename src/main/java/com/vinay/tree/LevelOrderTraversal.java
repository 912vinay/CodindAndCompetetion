package com.vinay.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree binaryTree = BinaryTreeUtil.insertData(ar);
        levelOrder(binaryTree);
        System.out.println("------------------------");
        levelOrderZizag(binaryTree);
        System.out.println("------------");
        levelOrderSignleQueue(binaryTree);
    }

    private static void levelOrderZizag(BinaryTree binaryTree) {

        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        boolean leftToRight = true;
        stack.add(binaryTree);
        while (!stack.isEmpty()) {
            BinaryTree temp = stack.pop();
            System.out.print(temp.getData() + " ");
            if (leftToRight) {
                if (temp.getLeft() != null)
                    stack2.push(temp.getLeft());
                if (temp.getRight() != null)
                    stack2.push(temp.getRight());

            } else {
                if (temp.getRight() != null)
                    stack2.push(temp.getRight());
                if (temp.getLeft() != null)
                    stack2.push(temp.getLeft());

            }
            if (stack.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<BinaryTree> temp2 = stack;
                stack = stack2;
                stack2 = temp2;
            }
        }
    }

    private static void levelOrder(BinaryTree binaryTree) {

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(binaryTree);
        while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();
            System.out.print(temp.getData() + " ");
            if (temp.getLeft() != null)
                queue.add(temp.getLeft());
            if (temp.getRight() != null)
                queue.add(temp.getRight());
        }
    }

    private static void levelOrderSignleQueue(BinaryTree binaryTree) {

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(binaryTree);
        boolean ltr = true;
        while (true) {

            int size = queue.size();
            while (size > 0) {
                BinaryTree temp = queue.poll();
                System.out.print(temp.getData() + " ");
                if (ltr) {
                    if (temp.getLeft() != null)
                        queue.add(temp.getLeft());
                    if (temp.getRight() != null)
                        queue.add(temp.getRight());

                } else {
                    if (temp.getRight() != null)
                        queue.add(temp.getRight());
                    if (temp.getLeft() != null)
                        queue.add(temp.getLeft());

                }
                size--;
            }
            if (queue.isEmpty())
                break;
            if (size == 0)
                ltr = !ltr;


        }
    }

}
