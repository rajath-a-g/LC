package Grokking;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int result1 = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result1);
        int result2 = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result2);
        int result3 = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result3);
    }
    public static int findMinSubArray(int S, int[] arr) {
        int n = arr.length;
        int windowStart = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            sum += arr[windowEnd];
            while (sum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                sum -= arr[windowStart++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
