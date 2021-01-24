package Amazon;

public class LargestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println("Largest is:" + longestPalindrome("babad"));
        System.out.println("Largest is:" + longestPalindrome("cbbd"));
        System.out.println("Largest is:" + longestPalindrome("a"));
        System.out.println("Largest is:" + longestPalindrome("ac"));
    }
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int left = i, right = i;
            while (left >= 0 && s.charAt(left) == c)
                left--;
            while (right < s.length() && s.charAt(right) == c)
                right++;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left = left + 1;
            if (end - start < right - left){
                start = left;
                end = right;
            }
        }
        return s.substring(start, end);
    }
}
