package com.vinay.design;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;

public class SignletonReflection {

    private static  SignletonReflection s;

    static {
        try {
            s = new SignletonReflection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SignletonReflection getInstance() {
        return s;
    }

    private SignletonReflection() throws Exception {

    }
}

class TestSignleton {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(SignletonReflection.getInstance());
        for(Constructor constructor:SignletonReflection.class.getDeclaredConstructors()) {
            constructor.setAccessible(true);
            SignletonReflection o = (SignletonReflection) constructor.newInstance();
            System.out.println(o);
        }
        HashSet<Integer> hs = new HashSet<>();
        hs.toArray();
    }
}
