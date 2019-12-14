package com.vinay.dp;

import com.vinay.array.ArrayUtil;

import java.util.Arrays;

public class PartitionArraytogetMinDiff {

    public static void main(String[] args) {

        int ar[] = {1, 6, 5, 11};
        int sum = Arrays.stream(ar).sum();
        int out = partitionRec(ar, ar.length, 0, sum);
        System.out.println(out);
        System.out.println(partitionDp(ar, ar.length, sum));


        int arr[] = {3, 1, 4, 2, 2, 1};
        sum = Arrays.stream(arr).sum();
        out = partitionRec(arr, arr.length, 0, sum);
        System.out.println(out);
        System.out.println(partitionDp(arr, arr.length, sum));
    }

    private static int partitionDp(int[] ar, int length, int sum) {
        boolean tab[][] = new boolean[length + 1][sum + 1];

        for (int i = 0; i <= length; i++)
            tab[i][0] = true;
        for (int i = 1; i <= sum; i++)
            tab[0][i] = false;

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum; j++) {
                tab[i][j] = tab[i - 1][j];
                if (ar[i - 1] <= j)
                    tab[i][j] |= tab[i - 1][j - ar[i - 1]];
            }
        }
        ArrayUtil.printArray(tab);
        for (int j = sum / 2; j >= 0; j--) {
            if (tab[length][j])
                return sum - 2 * j;
        }
        return -1;
    }

    private static int partitionRec(int[] ar, int length, int current, int sum) {

        if (length == 0)
            return Math.abs(sum - 2 * current);
        return Math.min(partitionRec(ar, length - 1, current + ar[length - 1], sum),
                partitionRec(ar, length - 1, current, sum));
    }
}
