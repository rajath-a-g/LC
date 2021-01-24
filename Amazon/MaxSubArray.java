package Amazon;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println("Largest Sum:" + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("Largest Sum:" + maxSubArray(new int[]{1}));
        System.out.println("Largest Sum:" + maxSubArray(new int[]{0}));
        System.out.println("Largest Sum:" + maxSubArray(new int[]{-1}));
        System.out.println("Largest Sum:" + maxSubArray(new int[]{-100000}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
