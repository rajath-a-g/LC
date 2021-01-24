package Grokking;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int ans = findMaxSumSubArray(k, arr);
        System.out.println(ans);
    }
    public static int findMaxSumSubArray(int k, int[] arr) {
        int n = arr.length;
        int max =Integer.MIN_VALUE;
        int sum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            sum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                max = Math.max(max, sum);
                sum -= arr[windowStart++];
            }
        }
        return max;
    }
}
