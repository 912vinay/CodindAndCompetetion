package com.vinay.array;

public class SegregateLowAndHigh {

    public static void main(String[] args) {
        int ar[] = {1, 4, 6, 44, 17, 9, 15, 6};
        segregateEventOdd(ar);
        ArrayUtil.printArray(ar);


    }

    private static void segregateEventOdd(int[] ar) {

        int l = 0;
        int h = ar.length - 1;
        while (l <= h) {
            if (ar[l] % 2 == 1) {
                int t = ar[l];
                ar[l] = ar[h];
                ar[h] = t;
                h--;
            } else
                l++;
        }

    }
}
