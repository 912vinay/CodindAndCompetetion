package com.vinay.array;

import java.util.Arrays;

public class PossibleNoOfTriangles {
    public static void main(String[] args) {
        int[] A = {4, 3, 5, 7, 6};
        countTriangles(A);
    }

    private static void countTriangles(int[] ar) {

        Arrays.sort(ar);
        int len = ar.length;
        int count = 0;
        for (int i = len - 1; i > 1; i--) {
            int l = 0;
            int h = i - 1;
            while (l < h) {
                if (ar[i] < ar[l] + ar[h]) {
                    count += (h - l);
                    h--;
                } else l++;

            }
        }
        System.out.println(count);
    }
}
