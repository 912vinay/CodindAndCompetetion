package com.vinay.matrix;

public class MinCostProblem {
    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        System.out.print(minCostTopDown(cost, 0, 0));
    }

    private static int minCostTopDown(int[][] cost, int i, int j) {

        if(i==cost.length-1 && j==cost[0].length-1)
            return cost[i][j];
        if (i < cost.length && j < cost[0].length) {
            return cost[i][j] + Math.min(minCostTopDown(cost, i + 1, j),
                    Math.min(minCostTopDown(cost, i + 1, j + 1),
                            minCostTopDown(cost, i, j + 1)));
        }
        return Integer.MAX_VALUE;
    }
}
