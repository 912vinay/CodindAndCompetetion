package com.vinay.array;

import java.util.Scanner;

public class MinMaxCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++)
        {
            int n=sc.nextInt();
            int min=sc.nextInt();
            int max=sc.nextInt();
            for(int i1=0;i1<n-1;i1++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                if(a<max && max<b)
                {
                    max=b;
                }
                else if(min<a && a<max)
                {
                    min =a;
                }
            }

            if(min <0 && max <0)
            {
                System.out.println(Math.abs(min+max));
            }
            else if(min >0 && max >0)
            {
                System.out.println(Math.abs(min+max));
            }
            else
                System.out.println(Math.abs(min)+1+max);
        }
    }
}
