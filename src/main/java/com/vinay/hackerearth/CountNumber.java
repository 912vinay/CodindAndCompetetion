package com.vinay.hackerearth;

import java.util.HashSet;
import java.util.Scanner;

public class CountNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        int max=0;
        for (int i = 0; i < n; i++) {

            ar[i] = sc.nextInt();
        }

        int lastIndex=ar.length;
        HashSet<Integer> uniq= new HashSet<>();
        for (int i = 0; i < lastIndex;i++ ) {
            if(uniq.contains(ar[i]))
                continue;
            uniq.add(ar[i]);
            HashSet<Integer> hs = new HashSet<>();
            int last = findLastIndex(ar, i)-1;
            hs.add(ar[i]);
            int start = i+1;
            while (start <= last) {
                hs.add(ar[start]);
                hs.add(ar[last]);
                start++;
                last--;
            }
            System.out.print(hs.size() + " ");
        }
    }

    private static int findLastIndex(int[] ar, int start) {

        for (int i = ar.length - 1; i > start; i--) {
            if (ar[i] == ar[start])
                return i;
        }
        return -1;
    }

}
