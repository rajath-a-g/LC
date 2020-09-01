/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.HashSet;
import java.util.Set;

public class Leet409 {
    public static void main(String[] args) {
        Leet409 leet409 = new Leet409();
        String s1 = "abccccdd";
        String res1 = leet409.longestPalindrome(s1);
        System.out.println(res1);
        String s2 = "babad";
        String res2 = leet409.longestPalindrome(s2);
        System.out.println(res2);
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        char d = ' ';
        for (char c : s.toCharArray()) {
            d = c;
            if (set.remove(c)) {
                stringBuilder.append(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? stringBuilder.toString() : stringBuilder.append(d).toString();
    }
}
