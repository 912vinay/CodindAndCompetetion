package com.vinay.array;

public class Nthpalindrome {

    public static void main(String[] args) {
        int n = 10;
        nthPalindrom(n);

    }

    private static void nthPalindrom(int n) {
        int t = 11;
        int count = 0;
        int c = 4;

        while (c<10) {
            int r = t * c;
            System.out.println(r);
            if (palindrom(r)) {
                count++;
            }
            if (count == n) {
                System.out.println(r);
                break;
            }
            c=c+4;

            System.out.println(count);
        }
    }

    private static boolean palindrom(int rt) {

        int r=rt;
        int rev = 0;
        while (r > 0) {
            int t = r % 10;
            rev = rev * 10 + t;
            r = r / 10;
        }
       // System.out.println(rev+" "+r);
        return rev == rt;
    }
}
