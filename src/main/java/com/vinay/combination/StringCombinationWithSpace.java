package com.vinay.combination;

public class StringCombinationWithSpace {

    public static void main(String[] args) {
        String str="ABC";
         char ar[]= new char[str.length()*2];
         ar[0]=str.charAt(0);
        possibleCombinationWithSpace(str,ar,1,1,str.length());
    }

    private static void possibleCombinationWithSpace(String str, char[] ar ,int i, int j,int n) {

       if(i==n) {
           ar[j]='\0';
           System.out.println(ar);
           return;
       }
       ar[j]=str.charAt(i);
       possibleCombinationWithSpace(str,ar,i+1,j+1,n);

        ar[j]=' ';
        ar[j+1]=str.charAt(i);
        possibleCombinationWithSpace(str,ar,i+1,j+2,n);
    }
}
