package com.vinay.conversion;

public class RomanNumberConvert {
    public static void main(String[] args) {

        int num = 3549;
        convertNum(num);
    }

    private static void convertNum(int num) {

        StringBuilder str = new StringBuilder();
        int n[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String c[] = {"I", "IV", "V","IX", "X", "XL", "L", "XC", "C", "CD", "D","CM","M"};
        int i = 12;
        while (num > 0) {
            int q = num / n[i];
            num = num % n[i];
            while (q > 0) {
                str.append(c[i]);
                q--;
            }
            i--;
        }
        System.out.println(str);
    }
}
