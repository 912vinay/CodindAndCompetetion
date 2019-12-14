package com.vinay.hackerearth.novcircuit;

import java.util.Scanner;

public class EuclideanDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = (int) Math.sqrt(Math.pow(n, 2) + Math.pow(n, 2));
        System.out.println("0 " + (n + 1));
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
