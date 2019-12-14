package com.vinay.dp.queen;

import com.vinay.array.ArrayUtil;

public class NQueensProblem {

    static int N = 4;

    /* ld is an array where its indices indicate row-col+N-1
    (N-1) is for shifting the difference to store negative
    indices */
    static int []ld = new int[30];

    /* rd is an array where its indices indicate row+col
    and used to check whether a queen can be placed on
    right diagonal or not*/
    static int []rd = new int[30];

    /*column array where its indices indicates column and
    used to check whether a queen can be placed in that
        row or not*/
    static int []cl = new int[30];

    public static void main(String[] args) {

        findNQueen(6);
    }

    private static void findNQueen(int n) {

        int queen[][] = new int[n][n];

        if (queenUtil(queen, 0, n))
            ArrayUtil.printArray(queen);
        System.out.println("No solution found");

    }

    private static boolean queenUtil(int[][] queen, int col, int n) {

        if (col >= n)
            return true;
        for (int row = 0; row < n; row++) {
            if (isSafe(queen, row, col, n)) {
                queen[row][col] = 1;
                if (queenUtil(queen, col + 1, n))
                    return true;
                queen[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] queen, int row, int col, int n) {

        for (int i = 0; i <= col; i++) {
            if (queen[row][i] == 1)
                return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (queen[i][j] == 1)
                return false;
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (queen[i][j] == 1)
                return false;
        }
        return true;

    }
    static boolean solveNQUtil(int board[][], int col)
    {
    /* base case: If all queens are placed
    then return true */
        if (col >= N)
            return true;

    /* Consider this column and try placing
    this queen in all rows one by one */
        for (int i = 0; i < N; i++)
        {

        /* Check if the queen can be placed on
        board[i][col] */
        /* A check if a queen can be placed on
        board[row][col].We just need to check
        ld[row-col+n-1] and rd[row+coln] where
        ld and rd are for left and right
        diagonal respectively*/
            if ((ld[i - col + N - 1] != 1 &&
                    rd[i + col] != 1) && cl[i] != 1)
            {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
                ld[i - col + N - 1] =
                        rd[i + col] = cl[i] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1))
                    return true;

            /* If placing queen in board[i][col]
            doesn't lead to a solution, then
            remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
                ld[i - col + N - 1] =
                        rd[i + col] = cl[i] = 0;
            }
        }

    /* If the queen cannot be placed in any row in
        this colum col then return false */
        return false;
    }

}
