package com.vinay.string;

public class convertStringOnetoTwo {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        int i = minCostToConvert(s1, s2, s1.length(), s2.length());
        System.out.println(i);


        i = minCostToConvertDp(s1, s2, s1.length(), s2.length());
        System.out.println(i);
    }

    private static int minCostToConvertDp(String s1, String s2, int l1, int l2) {

        int ar[][] = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0) {
                    ar[i][j] = j;
                } else if (j == 0) {
                    ar[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ar[i][j] = ar[i - 1][j - 1];
                } else {
                    ar[i][j] = 1 + Math.min(ar[i][j - 1], Math.min(ar[i - 1][j], ar[i - 1][j - 1]));
                }
            }
        }
        return ar[l1][l2];


    }

    private static int minCostToConvert(String s1, String s2, int l1, int l2) {

        if (l1 == 0)
            return l2;

        if (l2 == 0)
            return l1;
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
            return minCostToConvert(s1, s2, l1 - 1, l2 - 1);

        return 1 + Math.min(minCostToConvert(s1, s2, l1, l2 - 1), Math.min(minCostToConvert(s1, s2, l1 - 1, l2),
                minCostToConvert(s1, s2, l1 - 1, l2 - 1)));
    }
}
