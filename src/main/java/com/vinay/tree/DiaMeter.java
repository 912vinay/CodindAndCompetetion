package com.vinay.tree;

public class DiaMeter {
    public static void main(String[] args) {

        int ar[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree binaryTree = BinaryTreeUtil.insertData(ar);
        Hieght hieght = new Hieght();
        int diameter = diameter(binaryTree, hieght);
        System.out.println(diameter);

        Hieght hieght2 = new Hieght();
        diameterH(binaryTree, hieght2);
        System.out.println(hieght2.h);

    }

    private static int diameterH(BinaryTree binaryTree, Hieght hieght) {

        if (binaryTree == null)
            return 0;
        int lh = diameterH(binaryTree.getLeft(), hieght);
        int rh = diameterH(binaryTree.getRight(), hieght);
        hieght.h = Math.max(hieght.h, lh + rh + 1);
        return 1 + Math.max(lh, rh);
    }

    private static int diameter(BinaryTree binaryTree, Hieght hieght) {

        if (binaryTree == null) {
            hieght.h = 0;
            return 0;
        }

        Hieght lh = new Hieght(), rh = new Hieght();

        int ld = diameter(binaryTree.getLeft(), lh);
        int rd = diameter(binaryTree.getRight(), rh);

        hieght.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
    }


}

class Hieght {
    int h;
}
