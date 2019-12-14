package com.vinay.array;

public class DuplicateElementinLimitedArray {

    public static void main(String[] args) {
        int ar[]={1,2,3,4,7,4,6,3,6,5,9};
        printDuplicat(ar);
    }

    private static void printDuplicat(int[] ar) {

        for(int i=0;i<ar.length;i++)
        {
            if(ar[Math.abs(ar[i])]>=0)
            {
                ar[Math.abs(ar[i])]=-ar[Math.abs(ar[i])];
            }
            else {
                System.out.print(" "+Math.abs(ar[i]));
            }
        }
    }
}
