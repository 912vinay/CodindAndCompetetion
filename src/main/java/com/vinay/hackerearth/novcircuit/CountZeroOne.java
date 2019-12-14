package com.vinay.hackerearth.novcircuit;

import java.util.Scanner;

public class CountZeroOne {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        String  str = s.next();
        String zero =str.substring(0,str.lastIndexOf('z')+1);
        //System.out.println("z--- "+zero);
        String one =str.substring(str.lastIndexOf('z')+1,str.length());
        //System.out.println("on-- "+one);
        if((zero.length()*2) == one.length())
            System.out.println("Yes");
        else System.out.println("No");
    }
}
