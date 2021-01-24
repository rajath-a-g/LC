package JanuaryLeetcode2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParen {
    public static void main(String[] args) {
        System.out.println("IsValid? " + isValid("()"));
        System.out.println("IsValid? " + isValid("()[]{}"));
        System.out.println("IsValid? " + isValid("(]"));
        System.out.println("IsValid? " + isValid("([)]"));
        System.out.println("IsValid? " + isValid("{[]}"));
    }
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Map<Character, Character> check = new HashMap<>();
        check.put('(', ')');
        check.put('[', ']');
        check.put('{', '}');
        Stack<Character> track = new Stack<>();
        for (char c : s.toCharArray()) {
            if (check.containsKey(c)) {
                track.push(c);
            } else {
                if (check.get(track.peek()) == c)
                    track.pop();
                else
                    return false;
            }
        }
        return track.empty();
    }
}
