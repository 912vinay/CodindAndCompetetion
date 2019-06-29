package com.vinay.competetion.techgig.cd.jio;

import java.util.Scanner;

public class MaximumSubArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();
            int ar[] = new int[size];
            for (int l = 0; l < size; l++)
                ar[l] = sc.nextInt();
            int summax = 0;
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int k = size - 1; k > 0; k--) {
                StringBuilder stringBuilder = new StringBuilder();
                int localsum = ar[k];
                if (ar[k] > 0)
                    stringBuilder.append(ar[k]);
                for (int h = k - 2; h >= 0; h = h - 2) {
                    localsum += ar[h];
                    if (summax < localsum) {
                        summax = localsum;
                        if (ar[h] > 0) {
                            stringBuilder.append(ar[h]);
                            stringBuilder1.delete(0, stringBuilder1.length());
                            stringBuilder1.append(stringBuilder);
                        }

                    } else if (summax == localsum) {
                        String substring = stringBuilder.substring(stringBuilder.length() - 1, stringBuilder.length());
                        String substring1 = stringBuilder1.substring(stringBuilder1.length() - 1, stringBuilder1.length());

                        if (Integer.parseInt(substring) > Integer.parseInt(substring1)) {
                            stringBuilder1.delete(0, stringBuilder1.length());
                            stringBuilder1.append(stringBuilder);
                        }
                    }
                    if (localsum < 0) {
                        localsum = ar[k];
                        stringBuilder.delete(0, stringBuilder.length());
                        if (ar[k] > 0)
                            stringBuilder.append(ar[k]);
                       // stringBuilder.to
                    }
                }
            }

            System.out.println(stringBuilder1);
        }

    }
}
