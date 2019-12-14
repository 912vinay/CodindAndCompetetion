package com.vinay.array.sliding;

public class MaxElementinSubArray {

    public static void main(String[] args) {

        int ar[]={1,2,3,1,2,3,1,1,1,1,3,2,3,3,7,1,10};
        maxElementinSubArray(ar,3);
    }

    private static void maxElementinSubArray(int[] ar, int k) {

        int i=0;
        int maxsofar=ar[0];
        for(;i<k;i++)
        {
            if(maxsofar<ar[i])
                maxsofar=ar[i];
        }
        System.out.print(maxsofar+" ");
        for(;i<ar.length;i++)
        {
            if(maxsofar<ar[i])
                maxsofar=ar[i];
            System.out.print(maxsofar+" ");
        }

    }
}
