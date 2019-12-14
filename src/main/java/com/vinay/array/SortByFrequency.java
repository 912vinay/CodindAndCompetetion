package com.vinay.array;

import java.util.*;

public class SortByFrequency {

    public static void main(String[] args) {

        int ar[] = {1, 2, 2, 4, 5, 5, 6, 7, 5, 5};
        sortedArrays(ar);

    }

    private static void sortedArrays(int[] ar) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (!map.containsKey(ar[i])) {
                map.put(ar[i], 1);
            } else {
                map.put(ar[i], 1 + map.get(ar[i]));
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(map.entrySet());
        Collections.sort(arrayList, (e22, e3) -> {

            Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>) e22;
            Map.Entry<Integer, Integer> e2 = (Map.Entry<Integer, Integer>) e3;
            if (e.getValue() > e2.getValue())
                return 1;
            else if (e.getValue() < e2.getValue())
                return -1;
            return 0;
        });
        System.out.println(arrayList);
        arrayList.forEach(e -> {
            for (int i = 0; i < e.getValue(); i++) {
                System.out.print(e.getKey()+" ");
            }
        });

    }
}
