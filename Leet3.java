import java.util.HashSet;

public class Leet3 {
    public static void main(String[] args) {
        Leet3 leet3 = new Leet3();
        String test1 = "abcabcbb";
        int ans1 = leet3.lengthOfLongestSubstring(test1);
        System.out.println(ans1);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> check = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (i < n && j < n) {
            if (!check.contains(s.charAt(i++))) {
                check.add(s.charAt(j++));
                res = res > j - 1 ? res : j - 1;
            } else {
                check.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
