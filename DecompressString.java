/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.Stack;

public class DecompressString {
    public static void main(String[] args) {
        String input1 = "(abc(13)d)(2)";
        System.out.println(decompressStr(input1));
        String input2 = "((ab)(13)(cd)(3))(2)";
        System.out.println(decompressStr(input2));
    }
    private static String decompressStr(String str){
        Stack<String> stack = new Stack<>();
        int times = 0; // variable used to see if we need to multiple str times
        for(int k = 0; k < str.length(); ) {
            char ch = str.charAt(k);
            if(ch == '(') { //do nothing, push in stack to pop when we encounter ")"
                stack.push("(");
                k++;
            }else if(Character.isDigit(ch)) { //logic to read a digit [1,12,1234,3456]
                StringBuilder num = new StringBuilder();
                num.append(ch);
                k++;
                while(k+1 < str.length() && Character.isDigit(str.charAt(k))) {
                    num.append(str.charAt(k));
                    k++;
                }
                times = Integer.parseInt(num.toString());
            }else if(Character.isLetter(ch)) {
                stack.push(Character.toString(ch));
                k++;
            }else if(ch == ')') {
                StringBuilder sb = new StringBuilder();
                if(times == 0) { //times is not set, pop all values upto "(",combine them and push them back
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        sb.insert(0, stack.pop());
                    }
                    if (!stack.isEmpty())
                        stack.pop(); // "(" - pop the opening bracket after compute is done

                    stack.push(sb.toString());
                }else { //times is set, pop  the latest value from stack, multiple by times times and push back to stack
                    stack.pop(); // pop - "(" of the digit that was added
                    String product = stack.pop(); //str that needs multiplication
                    for(int i = 0; i < times; i++) {
                        sb.append(product);
                    }
                    stack.push(sb.toString());
                    times = 0; // reset to 0 for reading consecutive values from left to right
                }
                k++;
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) // To handle cases that has last letters after the string (ab(2)c)(2)d
            res.insert(0, stack.pop());
        return res.toString();
    }
}
