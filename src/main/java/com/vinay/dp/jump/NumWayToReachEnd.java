package com.vinay.dp.jump;

import com.vinay.array.ArrayUtil;

public class NumWayToReachEnd {

    public static void main(String[] args) {
        int ar[] = {3, 2, 0, 1};
        for (int i = 0; i < ar.length; i++) {
            int out = numOfwaytoReachEnd(ar, i, ar.length - 1);
            System.out.print(out + " ");
        }
        System.out.println();

        int ar3[] = {1, 3, 5, 8, 9, 1, 0, 7, 6, 8, 9};
        for (int i = 0; i < ar3.length; i++) {
            int out = numOfwaytoReachEnd(ar3, i, ar3.length - 1);
            System.out.print(out + " ");
        }

        numOfwaytoReachEndDp(ar3);
    }

    private static void numOfwaytoReachEndDp(int[] ar3) {

        int n = ar3.length;
        int jump[] = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (ar3[i] >= (n - 1 - i))
                jump[i]++;

            for (int j = i + 1; j < n && j <= i + ar3[i]; j++) {
                if (jump[j] != -1)
                    jump[i] += jump[j];
            }
            if (jump[i] == 0)
                jump[i] = -1;

        }
        System.out.println();
        ArrayUtil.printArray(jump);
    }

    private static int numOfwaytoReachEnd(int[] ar, int l, int h) {

        if (l == h)
            return 1;
        if (ar[l] == 0)
            return 0;
        int count = 0;
        for (int i = l + 1; i <= h && i <= l + ar[l]; i++) {
            count += numOfwaytoReachEnd(ar, i, h);
        }
        return count;
    }


}
