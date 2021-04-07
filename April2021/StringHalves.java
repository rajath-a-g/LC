package April2021;

import java.util.*;

public class StringHalves {
    public static void main(String[] args) {
        System.out.println("String are alike? " + halvesAreAlike("book"));
        System.out.println("String are alike? " + halvesAreAlike("textbook"));
        System.out.println("String are alike? " + halvesAreAlike("MerryChristmas"));
        System.out.println("String are alike? " + halvesAreAlike("AbCdEfGh"));
    }
    public static boolean halvesAreAlike(String s) {
        char[] vow = new char[]{'a', 'e', 'i', 'o', 'u'};
        Set<Character> vowels = new HashSet<>();
        for (char c : vow)
            vowels.add(c);
        s = s.toLowerCase();
        int mid = (s.length() + 1) / 2;
        int left = 0;
        int vowL = 0;
        while (left + mid < s.length()) {
            if (vowels.contains(s.charAt(left)))
                vowL++;
            if (vowels.contains(s.charAt(left + mid)))
                vowL--;
            left++;
        }
        return vowL == 0;
    }
}
