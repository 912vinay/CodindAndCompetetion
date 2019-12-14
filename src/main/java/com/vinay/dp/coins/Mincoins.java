package com.vinay.dp.coins;

import java.util.*;

public class Mincoins {

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is " + minCoinsR(coins, m, V));
        System.out.println("Minimum coins required is " + minCoinsDp(coins, m, V));
        System.out.println("Minimum coins required is " + minCoinsBfs(coins, m, V));
    }

    private static int minCoinsBfs(int[] coins, int m, int v) {

        Integer ar[]={1,3,4,5};
        HashSet<Integer> hash = new HashSet<>();
        List<Integer> lsi = new ArrayList<>();
        lsi.stream().reduce(Integer::sum);
        Queue<Integer> queue = new LinkedList();
        queue.add(v);
        int d = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while ((size-- > 0)) {
                int data = queue.poll();
                if (data == 0)
                    return d;
                if (hash.contains(d) || data < 0)
                    continue;
                hash.add(data);
                for (int i = 0; i < m; i++) {
                    queue.add(data - coins[i]);
                }

            }
            d++;
        }
        return -1;


    }

    private static int minCoinsDp(int[] coins, int m, int v) {

        int tab[] = new int[v + 1];
        Arrays.fill(tab, Integer.MAX_VALUE);
        tab[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= v; j++) {
                if (coins[i] <= j) {

                    int subres = tab[j - coins[i]];
                    if (subres != Integer.MAX_VALUE && subres + 1 < tab[j]) {
                        tab[j] = subres + 1;
                    }

                }
            }
        }
        return tab[v];

    }

    private static int minCoinsR(int[] coins, int m, int v) {
        if (v == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {

            if (coins[i] <= v) {
                int res = minCoinsR(coins, m, v - coins[i]);
                if (res + 1 < min && res != Integer.MAX_VALUE) {
                    min = res + 1;


                }
            }
        }
        return min;
    }

}
