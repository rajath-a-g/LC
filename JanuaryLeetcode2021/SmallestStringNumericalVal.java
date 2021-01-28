package JanuaryLeetcode2021;

import java.util.Arrays;

public class SmallestStringNumericalVal {
    public static void main(String[] args) {
        System.out.println("Smallest string is " + getSmallestString(3, 27));
        System.out.println("Smallest string is " + getSmallestString(5, 73));
    }

    public static String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int newchar = Math.min(25, k);
            res[i] += newchar;
            k -= newchar;
        }
        return String.valueOf(res);
    }
}
