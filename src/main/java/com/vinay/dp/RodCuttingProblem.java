package com.vinay.dp;

import com.vinay.array.ArrayUtil;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
        System.out.println("Maximum Obtainable Value is " +
                cutRodDP(arr, size));
    }

    private static int cutRodDP(int[] arr, int size) {
        int tab[] = new int[size + 1];
        tab[0] = 0;
        for (int i = 1; i <= size; i++) {

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, arr[j] + tab[i - j - 1]);
                System.out.print("-> "+max);
            }
            System.out.println();
            tab[i] = max;
        }
        ArrayUtil.printArray(tab);
        return tab[size];
    }


    private static int cutRod(int[] arr, int size) {

        if (size <= 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, arr[i] + cutRod(arr, size - i - 1));
        }
        return max;
    }
}
