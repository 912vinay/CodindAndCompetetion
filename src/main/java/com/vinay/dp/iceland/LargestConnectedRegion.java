package com.vinay.dp.iceland;

public class LargestConnectedRegion {

    static  int ROW;
    static  int COL;
    static int count;
    static int rowdi[]={-1,-1,-1,0,1,1,1,0};
    static int coldi[]={-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args) {

        int M[][] = { {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}};
        ROW = 4;
        COL = 5;
        System.out.println(largestRegion(M));
    }

    private static int largestRegion(int[][] m) {

        boolean visited[][]=new boolean[ROW][COL];
        int result=0;

        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COL;j++)
            {
                if(m[i][j]==1 && !visited[i][j])
                {
                    count=1;
                    dfsIceLand(m,i,j,visited);
                    result=Math.max(result,count);

                }

            }
        }
        return result;
    }

    private static void dfsIceLand(int[][] m, int i, int j, boolean[][] visited) {

        visited[i][j]=true;
        for(int k=0;k<8;k++)
        {
             if(isSafe(m,i+rowdi[k],j+coldi[k],visited))
             {
                 count++;
                 dfsIceLand(m,i+rowdi[k],j+coldi[k],visited);
             }
        }
    }

    private static boolean isSafe(int[][] m, int i, int j, boolean[][] visited) {

        return i>=0 && i<ROW && j>=0 && j<COL && m[i][j]==1 && !visited[i][j];
    }
}
