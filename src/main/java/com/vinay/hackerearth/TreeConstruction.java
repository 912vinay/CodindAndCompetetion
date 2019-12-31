package com.vinay.hackerearth;

import java.util.Scanner;

public class TreeConstruction {

     int max;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int data = s.nextInt();
        BinaryTree b = new BinaryTree(data);
        constructTree(s, n, b);
        TreeConstruction t = new TreeConstruction();
        diameter(t, b);
        System.out.println(t.max);

    }

    private static int diameter(TreeConstruction max, BinaryTree b) {

        if (b == null)
            return 0;
        int left = diameter(max, b.left);
        int right = diameter(max, b.right);

        max.max = Math.max(max.max, (left + right + 1));
        return Math.max(left, right) + 1;


    }

    private static void constructTree(Scanner s, int n, BinaryTree b) {
        for (int i = 1; i < n; i++) {
            String str = s.next();
            BinaryTree t = b;
            int d = s.nextInt();
            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == 'L') {
                    if (t.left == null)
                        t.left = new BinaryTree(d);
                    t = t.left;
                } else if (str.charAt(j) == 'R') {
                    if (t.right == null)
                        t.right = new BinaryTree(d);
                    t = t.right;
                }
            }


        }
    }

    static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int data) {
            this.data = data;
        }
    }


}

