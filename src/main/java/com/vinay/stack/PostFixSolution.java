package com.vinay.stack;

public class PostFixSolution {
    public static void main(String[] args) {
        String exp="231*+9-";
        for(int i=0;i<exp.length();i++)
        {
            if(Character.isDigit(exp.charAt(i)))
            {
                //char t=exp.charAt(i)-'0';
               // System.out.println(t);

            }
        }
    }
}
