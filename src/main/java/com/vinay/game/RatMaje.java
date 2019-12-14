package com.vinay.game;

import com.vinay.array.ArrayUtil;

public class RatMaje {
    public static void main(String[] args) {

        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        int N = maze.length;
        solveMaze(maze, N);
    }

    private static void solveMaze(int[][] maze, int n) {

        int sol[][] = new int[n][n];

        if (ratMajeUtil(maze, 0, 0, sol)) {
            ArrayUtil.printArray(sol);
        } else
            System.out.println("not possible");

    }

    private static boolean ratMajeUtil(int[][] maze, int x, int y, int[][] sol) {

        if (x == maze.length - 1 && y == maze.length - 1)
            return true;

        if (isSafe(maze, x, y)) {

            sol[x][y] = 1;
            if (ratMajeUtil(maze, x, y + 1, sol))
                return true;

            if (ratMajeUtil(maze, x + 1, y, sol))
                return true;
            sol[x][y] = 0;

        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {

        return x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1;
    }
}
