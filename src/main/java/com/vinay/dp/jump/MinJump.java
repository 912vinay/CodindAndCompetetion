package com.vinay.dp.jump;

import com.vinay.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinJump implements Comparator<MinJump> {
    public static void main(String[] args) {

        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
      //  System.out.print("Minimum number of jumps to reach end is "
      //          + minJumpsR(arr, 0, n - 1));

        int arr2[] = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        // calling minJumps method
        ArrayUtil.printArray(arr2);
        System.out.println(minJumpsDp(arr2,arr2.length));
        System.out.println(minJumps(arr2));


    }

    private static int minJumpsDp(int[] arr2, int length) {

        if(length==1 || arr2[0]==0)
            return Integer.MAX_VALUE;

        int t[]=new int[length];
        t[0]=0;

        for(int i=1;i<length;i++)
        {
             t[i]=Integer.MAX_VALUE;
             for(int j=0;j<i;j++)
             {
                   if(i<=j+arr2[j]  && t[j]!=Integer.MAX_VALUE)
                   {
                       t[i]=t[j]+1;
                       ArrayUtil.printArray(t);
                       break;
                   }
             }
        }
        return t[length-1];

    }

    private static int minJumpsR(int[] arr, int i, int h) {

        if (i == h)
            return 0;
        if (arr[i] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j <= h && j <= i + arr[i]; j++) {
            int t = minJumpsR(arr, j, h);
            if (t != Integer.MAX_VALUE && t + 1 < min)
                min = t + 1;
        }
        return min;

    }

    static int minJumps(int arr[])
    {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;


        // Start traversing array
        for (int i = 1; i < arr.length; i++)
        {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i+arr[i]);

            // we use a step to get to the current index
            System.out.println("maxreach "+maxReach);
            System.out.println("step "+step);
            step--;


            // If no further steps left
            if (step == 0)
            {
                //  we must have used a jump
                jump++;
                System.out.println("jum "+jump);
                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if(i>=maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
                System.out.println("after change step "+step);
            }
        }

        return -1;
    }

    @Override
    public int compare(MinJump o1, MinJump o2) {
        return 0;
    }
}
