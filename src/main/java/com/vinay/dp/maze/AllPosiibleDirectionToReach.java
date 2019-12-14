package com.vinay.dp.maze;

import com.vinay.array.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/
//https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
//https://www.geeksforgeeks.org/count-number-of-ways-to-reach-destination-in-a-maze/
//https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze
//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/


public class AllPosiibleDirectionToReach {
    public static void main(String[] args) {
        int ar[][] = {{1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}};

        boolean visited[][] = new boolean[5][5];
        List<String> list = new ArrayList<>();
        String path = "";
        possiblePath(ar, 0, 0, 5, 5, visited, list, path);
        System.out.println(list);
       // System.out.println(path);
        ArrayUtil.printArray(visited);
    }

    private static void possiblePath(int[][] ar, int r1, int c1, int r, int c, boolean[][] visited, List<String> list, String path) {

        if (!isSafe(ar, r1, c1, r, c, visited))
            return;
        if (r1 == r - 1 && c1 == c - 1) {
            list.add(path);
            return;

        }
        visited[r1][c1] = true;

        if (isSafe(ar, r1 + 1, c1, r, c, visited)) {
            path += "D";
            possiblePath(ar, r1 + 1, c1, r, c, visited, list, path);
            path = path.substring(0, path.length() - 1);
        }

        if (isSafe(ar, r1, c1 - 1, r, c, visited)) {
            path += "L";
            possiblePath(ar, r1, c1 - 1, r, c, visited, list, path);
            path = path.substring(0, path.length() - 1);
        }


        if (isSafe(ar, r1, c1 + 1, r, c, visited)) {
            path += "R";
            possiblePath(ar, r1, c1 + 1, r, c, visited, list, path);
            path = path.substring(0, path.length() - 1);
        }

        if (isSafe(ar, r1 - 1, c1, r, c, visited)) {
            path += "U";
            possiblePath(ar, r1 - 1, c1, r, c, visited, list, path);
            path = path.substring(0, path.length() - 1);
        }
        visited[r1][c1] = false;
    }

    private static boolean isSafe(int[][] ar, int r1, int c1, int r, int c, boolean[][] visited) {

        if (r1 < 0 || r1 >= r ||
                c1 < 0 || c1 >= c ||
                ar[r1][c1] == 0 ||
                visited[r1][c1])
            return false;
        return true;
    }
}
