package com.vinay.graph;

import java.util.*;

public class TreetravsersalWithoutLoopDimmestValue {

    private static int mindata = 10000000;
    private static int maxPath = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            Map<Integer, Boolean> checkLoop = new HashMap<>();
            Map<Integer, List<Integer>> integerListMap = creatTreeData(sc, checkLoop);
            int root = sc.nextInt();
            findMinimum(root, integerListMap, checkLoop,0);
            System.out.print(mindata);
            mindata = 10000000;
            maxPath = -1;
        }

    }

    private static void findMinimum(int root,
                                    Map<Integer, List<Integer>> integerListMap,
                                    Map<Integer, Boolean> checkLoop,int path) {

        if (path>maxPath) {
            mindata = root;
            maxPath=path;
        }

        if (checkLoop.get(root) == false) {
            checkLoop.put(root, true);
            List<Integer> integers = integerListMap.get(root);
            if (integers == null)
                return;
            for (Integer i : integers) {
                findMinimum(i, integerListMap, checkLoop,path+1);
            }
        }
    }

    private static Map<Integer, List<Integer>> creatTreeData(Scanner sc, Map<Integer, Boolean> checkLoop) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            checkLoop.put(s, false);
            checkLoop.put(d, false);
            if (map.containsKey(s)) {
                List<Integer> list = map.get(s);
                list.add(d);
                map.put(s, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(d);
                map.put(s, list);
            }
        }
        return map;

    }
}
