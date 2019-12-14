package com.vinay.dp;

import com.vinay.array.ArrayUtil;

public class OptimalStrategyGame {


    public static void main(String[] args) {
        int ar[] = {8, 15, 3, 7};
        int i = maxValue(ar, 4);
        System.out.println(i);

    }

    private static int maxValue(int[] ar, int n) {

        int tab[][] = new int[n][n];

        int x, y, z;
        ArrayUtil.printArray(tab);
        for (int gap = 0; gap < n; gap++) {
            for (int j = gap, i = 0; j < n; i++, j++) {
                x = ((i + 2) <= j) ? tab[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? tab[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? tab[i][j - 2] : 0;

                tab[i][j] = Math.max(Math.min(x, y) + ar[i], ar[j] + Math.min(y, z));
            }
        }

        ArrayUtil.printArray(tab);
        return tab[0][n - 1];

    }


}
