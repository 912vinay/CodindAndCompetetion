package com.vinay.combination;

public class AllPossibleSubsequence {

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(input.substring(3));
        String subseq = "";
        allpossibelsubseq(input, subseq, 0, input.length());
    }

    private static void allpossibelsubseq(String input, String subseq, int i, int length) {

        if (length < i)
            return;
        System.out.println(subseq);
        for (int j = i; j < length; j++) {
            subseq += input.charAt(j) + "";
            allpossibelsubseq(input, subseq, j + 1, length);
            subseq = subseq.substring(0, subseq.length() - 1);
        }
    }
}
