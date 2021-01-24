package Grokking.TwoPointer;

public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println("String 1 is palindrome? :" + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("String 1 is palindrome? :" + isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }
}
