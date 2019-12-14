package com.vinay.array;

import java.math.BigInteger;
import java.util.*;

public class MagicSequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            int ar[] = new int[n];
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
            }

            int total = (int) Math.pow(2, n);
            long count = 0;
            HashSet<String> hs = new HashSet<>();
            for (int c = 1; c < total; c++) {
                for (int j = 0; j < n; j++) {
                    if (BigInteger.valueOf(c).testBit(j)) {
                        list.add(ar[j]);
                        if (list.size() == k) {
                            Integer max = Collections.max(list);
                            Integer min = Collections.min(list);
                            if(max-min<=p)
                            {
                                
                            }

                            Collections.sort(list);
                           // System.out.println(list);
                            // System.out.println();
                            int prv = list.get(0);
                            int l = 1;
                            for (; l < list.size(); l++) {
                                if (list.get(l) - prv > p)
                                    break;
                                prv = list.get(l);
                            }
                            /*String st=list.toString().replace(",","").replace(" ","")
                                    .replace("[","").replace("]","").trim();
*/
                            /*System.out.println("list "+st +" has con "+hs.contains(st)
                            +" has "+hs+" l "+l+" final con "+ (l == list.size() && !hs.contains(st))+
                                    "value of p "+p);*/


                            if (l == list.size() && !hs.contains(list.toString())) {
                               // System.out.println(list);
                               // System.out.println("has inside "+hs);
                                count++;
                                hs.add(list.toString());
                            }
                            break;
                        }
                    }

                }
                list.clear();
            }

            System.out.println(count);
        }
    }
}
