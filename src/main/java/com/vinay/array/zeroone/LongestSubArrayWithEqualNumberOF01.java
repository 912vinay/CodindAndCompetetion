package com.vinay.array.zeroone;

import java.util.HashMap;

public class LongestSubArrayWithEqualNumberOF01 {

    public static void main(String[] args) {

        int ar[] = {1, 0, 1, 1, 1, 0, 0};
        maxSubArray(ar, ar.length);
    }

    private static void maxSubArray(int[] ar, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i] == 1)
                sum++;
            else sum--;

            if (sum == 0) {
                max = i + 1;
                end = i;
            }

            if (map.containsKey(sum)) {
                if (max < (i - map.get(sum))) {
                    max = i - map.get(sum);
                    end = i;
                }
            } else
                map.put(sum, i);

        }
        int start = end - max + 1;
        System.out.println(start + " " + end);


    }
}
