package com.vinay.array.rotation;

public class FindOutMaxElementInRotatedArray {

    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5, 6, 7};
        int i = maxElement(ar);
        System.out.println(i);

        int ar1[] = {7, 6, 5, 4, 3, 2, 1};
        int i1 = maxElement(ar1);
        System.out.println(i1);

        int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println(maxElement(arr));

        int arr2[] = {1, 3, 50, 10, 9, 7, 6};
        System.out.println(maxElement(arr2));

    }

    private static int maxElement(int[] ar) {

        int l = 0;
        int h = ar.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;

            if (mid - 1 < 0 && ar[mid] > ar[mid + 1])
                return ar[mid];
            if (mid + 1 >= ar.length && ar[mid] > ar[mid - 1])
                return ar[mid];
            if ((ar[mid] > ar[mid - 1] && ar[mid] > ar[mid + 1]))
                return ar[mid];

            if (ar[mid] > ar[mid - 1] && ar[mid] < ar[mid + 1])
                l = mid + 1;
            else
                h = mid - 1;
        }

        return -1111111111;

    }
}
