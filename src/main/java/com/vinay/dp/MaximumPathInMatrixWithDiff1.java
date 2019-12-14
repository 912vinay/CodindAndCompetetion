package com.vinay.dp;

import com.vinay.array.ArrayUtil;

import java.util.Arrays;

public class MaximumPathInMatrixWithDiff1 {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
        System.out.println("Length of the longest path is " + finLongestOverAll(mat, 3, 3));

    }

    private static int finLongestOverAll(int[][] mat, int r, int c) {

        int tab[][] = new int[r][c];

        for (int i = 0; i < r; i++)
            Arrays.fill(tab[i], -1);
        ArrayUtil.printArray(tab);
        int result = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (tab[i][j] == -1) {
                    maxCount(mat, tab, i, j, r, c);
                }
                result = Math.max(result, tab[i][j]);
            }
        }
        ArrayUtil.printArray(tab);
        return result;
    }

    private static int maxCount(int[][] mat, int[][] tab, int i, int j, int r, int c) {


        if (tab[i][j] != -1)
            return tab[i][j];

        if (i < 0 || i >= r || j < 0 || j >= c)
            return 0;


        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int z = Integer.MIN_VALUE;
        int z2 = Integer.MIN_VALUE;
        if (i < r - 1 && (mat[i][j] + 1 == mat[i + 1][j]))
            z2 = 1 + maxCount(mat, tab, i + 1, j, r, c);

        if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j]))
            z = 1 + maxCount(mat, tab, i - 1, j, r, c);


        if (j < c - 1 && (mat[i][j] + 1 == mat[i][j + 1]))
            x = 1 + maxCount(mat, tab, i, j + 1, r, c);

        if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1]))
            y = 1 + maxCount(mat, tab, i, j - 1, r, c);

        tab[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(z2, 1))));
        return tab[i][j];


    }


}
