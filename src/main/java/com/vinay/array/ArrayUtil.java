package com.vinay.array;

public class ArrayUtil {

    public static void printArray(int ar[]) {
        for (int i = 0; i < ar.length; i++)
            System.out.print(ar[i] + " ");
        System.out.println();
    }

    public static void printArray(boolean ar[][]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j])
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[][] tab) {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
