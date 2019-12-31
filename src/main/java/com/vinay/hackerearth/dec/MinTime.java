package com.vinay.hackerearth.dec;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MinTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {


            float x = scanner.nextFloat();
            int y = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            System.out.println(x);
            DecimalFormat df = new DecimalFormat("#.#####");;
            BigDecimal sqrtLand = new BigDecimal(Math.sqrt(Math.pow(Math.abs(x1 - x), 2) +
                    Math.pow(Math.abs(y - 0), 2)));
           // System.out.printf("%.3f",sqrtLand);
            //System.out.println(df.format(Math.sqrt(Math.pow(Math.abs(x1 - x), 2) +
                   // Math.pow(Math.abs(0 - y), 2))));
            BigDecimal timeInland = new BigDecimal(sqrtLand.doubleValue() / (double)v1);
           // System.out.printf("%.5f",timeInland);
            //System.out.println(timeInland);
            BigDecimal sqrtSea =new BigDecimal( Math.sqrt(
                    Math.pow(Math.abs(0 - y1), 2)));
            BigDecimal timeSea =new BigDecimal( sqrtSea.doubleValue() / (double)v2);

           // System.out.println(df.format(timeInland + timeSea));
            BigDecimal b = new BigDecimal(timeInland.doubleValue()+timeSea.doubleValue());
            System.out.printf("%.5f",b);


        }
    }
}
