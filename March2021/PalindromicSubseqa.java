package March2021;

public class PalindromicSubseqa {
    public static void main(String[] args) {
        System.out.println("Steps to reduce:" + removePalindromeSub("ababa"));
    }
    public static int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String reversedString = new StringBuilder(s).reverse().toString();
        if (reversedString.equals(s)) {
            return 1;
        }
        return 2;
    }
}
