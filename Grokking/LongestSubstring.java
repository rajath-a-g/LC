package Grokking;

import java.util.HashMap;

//Problem Statement
//        Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
//        Example 1:
//        Input: String="aabccbb", k=2
//        Output: 5
//        Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
//        Example 2:
//        Input: String="abbcb", k=1
//        Output: 4
//        Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
//        Example 3:
//        Input: String="abccde", k=1
//        Output: 3
//        Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println("Length of longest substring is: " + lengthLongestSubstring("aabccbb", 2));
        System.out.println("Length of longest substring is: " + lengthLongestSubstring("abbcb", 1));
        System.out.println("Length of longest substring is: " + lengthLongestSubstring("abccde", 1));
    }

    public static int lengthLongestSubstring(String str , int k) {
        int windowStart = 0, max_length = 0, max_repeat = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            map.put(right, map.getOrDefault(right, 0) + 1);
            max_repeat = Math.max(max_repeat, map.get(right));
            if (windowEnd - windowStart + 1 - max_repeat > k) {
                char left = str.charAt(windowStart);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0)
                    map.remove(left);
                windowStart++;
            }
            max_length = Math.max(max_length, windowEnd - windowStart + 1);
        }
        return max_length;
    }
}
