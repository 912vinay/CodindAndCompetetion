package com.vinay.array;

public class XORs {


    public static void main(String[] args) {
        int ar[] = {1, 2, 3};

        int i = xorOfXor(ar);
        System.out.println(i);

        int ar2[] = {3, 5, 2, 4, 6};

        i = xorOfXorOptimise(ar2);
        System.out.println(i);
    }

    /* no of sub array of given array size n   sum= n(n+1)/2*/
    private static int xorOfXorOptimise(int[] ar2) {

        int result = 0;
        for (int i = 0; i < ar2.length; i++) {
            int count = (i + 1) * (ar2.length - i);
            if (count % 2 == 1)
                result ^= ar2[i];
        }
        return result;
    }

    /* Brut force approach*/
    private static int xorOfXor(int[] ar) {
        int result = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                for (int k = i; k <= j; k++)
                    result ^= ar[k];
            }
        }
        return result;
    }

/* As in above example,
3 occurred 5 times,
5 occurred 8 times,
2 occurred 9 times,
4 occurred 8 times,
6 occurred 5 times
So our final result will be xor of all elements which occurred odd number of times
i.e. 3^2^6 = 7

From above occurrence pattern we can observe that number at i-th index will have
(i + 1) * (N - i) frequency.*/


}
