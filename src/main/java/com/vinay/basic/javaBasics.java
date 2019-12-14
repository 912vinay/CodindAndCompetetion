package com.vinay.basic;

import java.util.HashSet;

public class javaBasics {

    public static void main(String[] args) {
        byte i = 1;
        HashSet<String> hs= new HashSet<>();
        String a="abc";
        String sring= new String("abc");
        hs.add(sring);
        System.out.println(hs.size());
        javaBasics javaBasics= new javaBasics();
        System.out.println(javaBasics.method());
        // i=  i++  +i; // compile time error.
    }

    public  int method()
    {
        try {
            System.out.println("hji");
            return 1;
        }
        finally {
            System.out.println("finally");
            return 2;
        }
    }
}
