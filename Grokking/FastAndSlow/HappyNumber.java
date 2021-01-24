package Grokking.FastAndSlow;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(19 + " is happy? " + isHappy(19));
        System.out.println(2 + " is happy? " + isHappy(2));
    }
    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }
    public static boolean isHappy(int n) {
        int fast = sumOfSquares(n), slow = n;
        while (fast != 1 && fast != slow) {
            slow = sumOfSquares(n);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }
}
