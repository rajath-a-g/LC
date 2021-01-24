package Grokking;
//Problem Statement
//        Given a string, find the length of the longest substring which has no repeating characters.
//        Example 1:
//        Input: String="aabccbb"
//        Output: 3
//        Explanation: The longest substring without any repeating characters is "abc".
//        Example 2:
//        Input: String="abbbb"
//        Output: 2
//        Explanation: The longest substring without any repeating characters is "ab".
//        Example 3:
//        Input: String="abccde"
//        Output: 3
//        Explanation: Longest substrings without any repeating characters are "abc" & "cde".

import java.util.HashMap;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println("Length of substring: " + noRepeat("aabccbb"));
        System.out.println("Length of substring: " + noRepeat("abbbb"));
        System.out.println("Length of substring: " + noRepeat("abccde"));
    }
    public static int noRepeat(String str) {
        int windowStart = 0, max_length = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            if (map.containsKey(right))
                windowStart = Math.max(windowStart, map.getOrDefault(right, 0) + 1);
            map.put(right, windowEnd);
            max_length = Math.max(max_length, windowEnd - windowStart + 1);
        }
        return max_length;
    }
}
