package com.vinay.array.rotation;

public class findMaxInSortedRotated {

    public static void main(String[] args) {

        int ar[]={7,0,1,2,3,4};
        int val=findMax(ar);
        System.out.println(val);

        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         val=findMax(arr1);
        System.out.println(val);
    }

    private static int findMax(int[] ar) {

        int l=0;
        int h=ar.length-1;
        while(l<=h)
        {
            int m=(l+h)/2;
            if(m<h && ar[m]>ar[m+1])
                return  m+1;
            if(m>l && ar[m-1]>ar[m])
                return  m;
            if(ar[m]<=ar[h])
            {
                h=m-1;
            }
            else
                l=m+1;


        }
        return -1;
    }
}
