package com.vinay.hackerearth.novcircuit;

import com.vinay.array.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColorGraph {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int v = s.nextInt();                 // Reading input from STDIN
        int terminal = s.nextInt();
        List<Integer> list[] = new ArrayList[v + 1];
        for (int i = 1; i < v; i++) {
            int u = s.nextInt();
            int v1 = s.nextInt();
            if (list[u] == null) {
                list[u] = new ArrayList<>();
                list[u].add(v1);
            } else {
                list[u].add(v1);
            }

            if (list[v1] == null) {
                list[v1] = new ArrayList<>();
                list[v1].add(u);
            } else {
                list[v1].add(u);
            }
        }

        ArrayList<Integer> tab = new ArrayList();
        for (int i = 0; i < terminal; i++) {
            tab.add(s.nextInt());
        }

        int result = v;
        for (int i = 1; i <= v; i++) {

            if (list[i] != null) {
                if (list[i].size() == 1 && !tab.contains(i)) {
                    result--;
                }

            }

        }
        System.out.println(result);
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

    }
}
