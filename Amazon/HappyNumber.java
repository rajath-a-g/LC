package Amazon;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println("Number is happy? " + isHappy(19));
        System.out.println("Number is happy? " + isHappy(2));
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }
    //Floyd's cycle finding algo
    public static boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
