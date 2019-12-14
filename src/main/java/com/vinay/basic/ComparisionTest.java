package com.vinay.basic;

public class ComparisionTest {

    public static void main(String[] args) {

        Integer i = new Integer(25);
        Integer i2 = new Integer(25);
        System.out.println(i.hashCode());
        System.out.println(i2.hashCode());
        System.out.println(i==i2);
        System.out.println(i.equals(i2));
    }
}
