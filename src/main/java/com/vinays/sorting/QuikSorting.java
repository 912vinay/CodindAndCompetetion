package com.vinays.sorting;

import com.vinay.array.ArrayUtil;

public class QuikSorting {

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quikSort(arr, 0, n - 1);
        ArrayUtil.printArray(arr);
    }

    private static void quikSort(int[] arr, int l, int h) {

        if (l < h) {
            int pivote = partition(arr, l, h);
            quikSort(arr,l,pivote-1);
            quikSort(arr,pivote+1,h);
        }
    }

    private static int partition(int[] arr, int l, int h) {

        int pivot = arr[h];
        int j = l - 1;
        for (int i = l; i < h; i++) {
            if (arr[i] <= pivot) {
                j++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        j++;
        //int t=pivot;
        arr[h] = arr[j];
        arr[j] = pivot;
        return j;
    }
}
