package com.vinay.stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        nextGrtEl(arr, arr.length);
    }

    private static void nextGrtEl(int[] arr, int length) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for (int i = length - 1; i >= 0; i--) {
            int t = stack.peek();
            if (t > arr[i]) {
                System.out.println(arr[i] + " " + t);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    System.out.println(arr[i] + " " + (-1));
                else
                    System.out.println(arr[i] + " " + stack.peek());

            }
            stack.push(arr[i]);
        }

    }
}
