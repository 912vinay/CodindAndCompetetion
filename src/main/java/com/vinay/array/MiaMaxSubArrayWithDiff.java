package com.vinay.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;


public class MiaMaxSubArrayWithDiff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
                arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }
            int K = Integer.parseInt(br.readLine());
            int[] out_ = GoodSubArray(arr, K, N);
            wr.print(out_[0]);
            for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
                wr.print(" ");
                wr.print(out_[i_out_]);
            }
            wr.println();
        }

        wr.close();
        br.close();
    }

    static int[] GoodSubArray(int[] arr, int K, int N) {
        int ar[] = new int[N];
        ar[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] + K == arr[i + 1])
                ar[i] += (ar[i+1] + 1);
            else
                ar[i] = 1;
        }
        return ar;


    }
}
