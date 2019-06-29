package com.vinay.walmart.practice;

import java.util.Stack;

public class ParenthesisBalance {

    public static void main(String[] args) {
        String exp = "{()}[]";
        System.out.println(isBalanced(exp));
     exp = "{()}[]]";
        System.out.println(isBalanced(exp));
    }

    private static boolean isBalanced(String exp) {
        Character character;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '{' ||
                    exp.charAt(i) == '[' ||
                    exp.charAt(i) == '(') {
                stack.push(exp.charAt(i));
            }

            if (stack.isEmpty())
                return false;

            switch (exp.charAt(i)) {


                case ')':
                    character = stack.pop();
                    if (character == '{' || character == '[')
                        return false;
                    break;

                case ']':
                    character = stack.pop();
                    if (character == '{' || character == '(')
                        return false;
                    break;

                case '}':
                    character = stack.pop();
                    if (character == '(' || character == '[')
                        return false;
                    break;
            }
        }
        return true;

    }

}
