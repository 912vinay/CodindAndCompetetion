package com.vinay.design;

import java.util.*;

public class Lru {
    public static void main(String[] args) {

        int ar[] = {1, 2, 3, 1, 4, 5};
        int size = 4;
        lruAlogo(ar, size);


        /*Deque<Integer> deque = new LinkedList<>();
        System.out.println(deque);
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque);
        System.out.println(deque.remove(3));
        System.out.println(deque);*/


    }

    private static void lruAlogo(int[] ar, int size) {

        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            if (!hash.contains(ar[i])) {
                if (deque.size() == size) {
                    Integer integer = deque.removeLast();
                    hash.remove(integer);
                }
            } else {
                deque.remove(ar[i]);
                System.out.println("test "+deque);
            }
            deque.push(ar[i]);
            hash.add(ar[i]);
            System.out.println("insdie "+deque);
        }
        System.out.println(deque);
    }
}
