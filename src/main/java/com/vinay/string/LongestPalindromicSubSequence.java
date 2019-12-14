package com.vinay.string;

public class LongestPalindromicSubSequence {

    public static void main(String[] args) {

        String str = "abcad";
        int i = longestPalindromeRec(str, 0, str.length() - 1);
        System.out.println(i);

        i = longestPalindromeRecDP(str);
        System.out.println(i);
    }

    private static int longestPalindromeRecDP(String str) {


        int ar[][] = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++)
            ar[i][i] = 1; // palindrome of size of 1


        for (int cl = 2; cl <= str.length(); cl++) {
            for (int i = 0; i < str.length() - cl + 1; i++) {
                int j = i + cl - 1;
                if (cl == 2 && isSame(str.charAt(i), str.charAt(j)))
                    ar[i][j] = 2;
                else if (isSame(str.charAt(i), str.charAt(j))) {
                    ar[i][j] = ar[i + 1][j - 1] + 2;
                } else
                    ar[i][j] = Math.max(ar[i + 1][j], ar[i][j - 1]);
            }
        }

        return ar[0][str.length()-1];

    }

    private static int longestPalindromeRec(String str, int x, int y) {
        if (str == null || str.isEmpty())
            return 0;
        if (isSame(x, y))
            return 1;
        if (isSame(x, y - 1) && isSame(str.charAt(x), str.charAt(y)))
            return 2;
        if (isSame(str.charAt(x), str.charAt(y)))
            return longestPalindromeRec(str, x + 1, y - 1) + 2;

        return Math.max(longestPalindromeRec(str, x + 1, y), longestPalindromeRec(str, x, y - 1));


    }

    private static boolean isSame(int c, int c2) {
        return c == c2;
    }
}
