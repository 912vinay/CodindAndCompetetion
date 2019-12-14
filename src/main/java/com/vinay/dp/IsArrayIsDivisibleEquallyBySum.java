package com.vinay.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class IsArrayIsDivisibleEquallyBySum {


    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {5, 5, 1, 11};
        int n = arr.length;
        if (isPartitionPoss(arr, n) == false) {
            System.out.print("-1");


        }

        if (isPartitionPossSumDP(arr, n) == false) {
            System.out.print("-1");
        }

        int vec[] = {1, 7, 15, 29, 11, 9};
        n = vec.length;
        if (isPartitionPossAvg(vec, n) == false) {
            System.out.print("-1");
        }
    }

    private static boolean isPartitionPoss(int arr[], int n) {

        int sum = Arrays.stream(arr).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        list2.clear();
        list1.clear();

        return fillttheList(arr, n, 0, 0, 0);

    }


    private static boolean fillttheList(int[] arr, int n, int sum1, int sum2, int pos) {

        if (n == pos) {

            if (sum1 == (sum2)) {
                System.out.println(list1);
                System.out.println(list2);
                System.out.println("End of printing");
                return true;
            }
            return false;

        }

        list1.add(arr[pos]);
        boolean res = fillttheList(arr, n, sum1 + arr[pos], sum2, pos + 1);

        if (res) {
            return res;
        }
        list1.remove(list1.size() - 1);
        list2.add(arr[pos]);
        res = fillttheList(arr, n, sum1, sum2 + arr[pos], pos + 1);
        if (!res) {
            list2.remove(list2.size() - 1);
        }
        return res;


    }

    private static boolean isPartitionPossAvg(int[] arr, int n) {

        list2.clear();
        list1.clear();

        return filterListForAverage(arr, n, 0, 0, 0);

    }


    private static boolean filterListForAverage(int[] arr, int n, int sum1, int sum2, int pos) {

        if (n == pos) {

           /* System.out.println("test " + list1.size() + " " + list2.size() + " " + sum1 + " " + sum2
                    + " " + list1 + " " + list2);*/
            if (list2.size() > 0 && list1.size() > 0 && (sum1 * list2.size()) == (sum2 * list1.size())) {
                System.out.println("result=-------------");
                System.out.println(list1);
                System.out.println(list2);
                System.out.println("End of printing");
                return true;
            }
            return false;

        }

        list1.add(arr[pos]);
        boolean res = filterListForAverage(arr, n, sum1 + arr[pos], sum2, pos + 1);

        if (res) {
            return res;
        }
        list1.remove(list1.size() - 1);
        list2.add(arr[pos]);
        res = filterListForAverage(arr, n, sum1, sum2 + arr[pos], pos + 1);
        if (!res) {
            list2.remove(list2.size() - 1);
        }
        return res;


    }


    private static boolean isPartitionPossSumDP(int[] arr, int n) {
        list1.clear();
        list2.clear();

        int sum = Arrays.stream(arr).sum();
        sum = sum >> 1;
        boolean tab[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            tab[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            tab[0][i] = false;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                tab[i][j] = tab[i - 1][j];
                if (arr[i - 1] <= j)
                    tab[i][j] |= tab[i - 1][j - arr[i - 1]];
            }
        }

        if (tab[n][sum]) {
            int i = n;
            int cu = sum;

            while (i > 0 && cu >= 0) {

                if (tab[i - 1][cu]) {
                    i--;
                    list2.add(arr[i]);
                } else if (tab[i - 1][cu - arr[i - 1]]) {
                    i--;
                    list1.add(arr[i]);
                    cu -= arr[i];
                }
            }
            System.out.println(list1);
            System.out.println(list2);
            System.out.println();
        }
        return tab[n][sum];
    }
}
