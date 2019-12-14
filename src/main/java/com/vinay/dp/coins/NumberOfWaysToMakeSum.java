package com.vinay.dp.coins;

import com.vinay.array.ArrayUtil;

import java.util.Arrays;

public class NumberOfWaysToMakeSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(countWayR(arr, m, 4));
        System.out.println(countWayDp(arr, m, 4));
    }

    private static int countWayDp(int[] arr, int m, int n) {
        int tab[] = new int[n + 1];
        Arrays.fill(tab, 0);
        tab[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = arr[i]; j <= n; j++) {
                tab[j] += tab[j - arr[i]];

                ArrayUtil.printArray(tab);
            }
        }
        ArrayUtil.printArray(tab);
        return tab[n];
    }

    private static int countWayR(int[] arr, int m, int n) {

        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (n > 0 && m <= 0)
            return 0;
        return countWayR(arr, m - 1, n) + countWayR(arr, m, n - arr[m - 1]);

    }

}
