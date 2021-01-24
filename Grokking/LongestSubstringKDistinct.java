package Grokking;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
    }
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) return -1;
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            freq.put(right, freq.getOrDefault(right, 0) + 1);
            while (freq.size() > k) {
                char left = str.charAt(windowStart);
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0)
                    freq.remove(left);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
