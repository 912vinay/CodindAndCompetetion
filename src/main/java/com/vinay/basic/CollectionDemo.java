package com.vinay.basic;

import java.util.Hashtable;

class  Parent
{
    String st="parent";
    public String getPrice()
    {
        return "parent price";
    }
    static {
        System.out.println("Parent statitc");
    }
    Parent()
    {
        System.out.println("Parent Constr");
    }
}

public class CollectionDemo extends  Parent{

    String st="CollectionDemo";
    public String getPrice()
    {
        return "CollectionDemo price";
    }
    CollectionDemo()
    {
        System.out.println("collectiodemo const");
    }
    static {
        System.out.println("CollectionDemo statitc");
    }

    public static void main(String[] args) {
        Hashtable<String,String> hashtable=new Hashtable<>();
       // hashtable.put("123","123value");
        Parent parent=new CollectionDemo();
        System.out.println(parent.st);
        System.out.println(parent.getPrice());
        hashtable.put(null,null);
        System.out.println(hashtable);
    }
}
