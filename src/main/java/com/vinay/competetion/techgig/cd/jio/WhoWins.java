package com.vinay.competetion.techgig.cd.jio;

import java.util.Arrays;
import java.util.Scanner;

public class WhoWins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int size = sc.nextInt();
            int player[] = new int[size];
            int villains[] = new int[size];

            for (int i = 0; i < size; i++)
                player[i] = sc.nextInt();

            for (int i = 0; i < size; i++)
                villains[i] = sc.nextInt();

            Arrays.sort(player);
            Arrays.sort(villains);

            String str = "WIN";
            for (int i = 0; i < size; i++) {
                if (player[i] < villains[i]) {
                    str = "LOSE";
                    break;
                }
            }
            System.out.println(str);
        }
    }
}


