package com.vinay.string;

public class LogestPalindromeSubString {

    public static void main(String[] args) {

        String str = "absadrdarpkrqprtrpq";
        String s = longestSubstring(str);
        System.out.println(s);
    }

    private static String longestSubstring(String str) {


        int max = 1;
        int start = 0;
        for (int i = 1; i < str.length(); i++) {

            int low = i - 1;
            int high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if ((high - low + 1) > max) {
                    start = low;
                    max = high - low + 1;
                }
                low--;
                high++;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if ((high - low + 1) > max) {
                    start = low;
                    max = high - low + 1;
                }
                low--;
                high++;
            }

        }
        return str.substring(start, start + max);
    }
}
