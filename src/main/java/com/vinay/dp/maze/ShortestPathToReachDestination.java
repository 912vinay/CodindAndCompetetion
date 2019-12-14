package com.vinay.dp.maze;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToReachDestination {

    public static void main(String[] args) {

        int[][] ar = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        boolean visited[][] = new boolean[9][9];
        int i = shortesPath(ar, 0, 0, 3, 4, visited);
        System.out.println(i);

    }

    private static int shortesPath(int[][] ar, int x, int y, int dx, int dy, boolean[][] visited) {

        if (!isSafe(ar, x, y, dx, dy, visited))
            return -1;

        Queue<PathData> queue = new LinkedList<>();
        visited[x][y] = true;
        PathData pathData = new PathData(x, y, 0);
        queue.add(pathData);
        while ((!queue.isEmpty())) {
            pathData = queue.poll();
            if (pathData.x == dx && pathData.y == dy)
                return pathData.d;

            if (isSafe(ar, pathData.x + 1, pathData.y, dx, dy, visited)) {
                visited[pathData.x + 1][pathData.y] = true;
                PathData pathData1 = new PathData(pathData.x + 1, pathData.y, pathData.d + 1);
                queue.add(pathData1);
            }

            if (isSafe(ar, pathData.x - 1, pathData.y, dx, dy, visited)) {
                visited[pathData.x - 1][pathData.y] = true;
                PathData pathData1 = new PathData(pathData.x - 1, pathData.y, pathData.d + 1);
                queue.add(pathData1);
            }

            if (isSafe(ar, pathData.x, pathData.y + 1, dx, dy, visited)) {
                visited[pathData.x][pathData.y + 1] = true;
                PathData pathData1 = new PathData(pathData.x, pathData.y + 1, pathData.d + 1);
                queue.add(pathData1);
            }

            if (isSafe(ar, pathData.x, pathData.y - 1, dx, dy, visited)) {
                visited[pathData.x][pathData.y - 1] = true;
                PathData pathData1 = new PathData(pathData.x, pathData.y - 1, pathData.d + 1);
                queue.add(pathData1);
            }


        }
        return -1;

    }

    private static boolean isSafe(int[][] ar, int x, int y, int dx, int dy, boolean[][] visited) {


        if (x < 0 || x > dx || y < 0 || y > dy || ar[x][y] == 0 || visited[x][y])
            return false;
        return true;


    }

    static class PathData {
        int x;
        int y;
        int d;

        public PathData(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
