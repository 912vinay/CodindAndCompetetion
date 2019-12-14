package com.vinay.dp.jump;

public class ToReachNthStairs {


    public static void main(String[] args) {
        int n = 4, m = 2;
        int i = reachNthStair(n, m);
        System.out.println(i);

        i = reachNthStairDp(n, m);
        System.out.println(i);
    }

    private static int reachNthStairDp(int n, int m) {

        int t[] = new int[n + 1];
        t[0] = 1;
        t[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j=1;j<=m && j<=i;j++)
                t[i]+=t[i-j];
        }
        return  t[n];
    }

    private static int reachNthStair(int n, int m) {

        if (n <= 1)
            return 1;
        int res = 0;
        for (int i = 1; i <= n && i <= m; i++)
            res += reachNthStair(n - i, m);
        return res;

    }

}
