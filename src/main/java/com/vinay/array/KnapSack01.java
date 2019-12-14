package com.vinay.array;

public class KnapSack01 {

    public static void main(String[] args) {
        int v[] = {160, 100, 120};
        int w[] = {10, 20, 30};
        int W = 50;
        int i = maxValue(v, w, W, v.length);
        System.out.println(i);

        i = maxValueDp(v, w, W, v.length);
        System.out.println(i);
    }

    private static int maxValueDp(int[] v, int[] w, int w1, int length) {
        int tab[][] = new int[length + 1][w1 + 1];
        for (int i = 0; i <= length; i++) {

            for (int j = 0; j <= w1; j++) {
                if (i == 0 || j == 0)
                    tab[i][j] = 0;
                else if (w[i - 1] <= j) {
                    tab[i][j] = Math.max(v[i - 1] + tab[i - 1][j - w[i - 1]], tab[i - 1][j]);
                } else {
                    tab[i][j] = tab[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= w1; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        return tab[length][w1];

    }

    private static int maxValue(int[] v, int[] w, int w1, int n) {

        if (n == 0 | w1 == 0)
            return 0;

        if (w[n - 1] > w1)
            return maxValue(v, w, w1, n - 1);

        else {
            return Math.max(v[n - 1] + maxValue(v, w, w1 - w[n - 1], n - 1),
                    maxValue(v, w, w1, n - 1));
        }
    }
}
