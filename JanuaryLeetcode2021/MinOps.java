package JanuaryLeetcode2021;

import java.util.Arrays;

public class MinOps {
    public static void main(String[] args) {
        System.out.println("Min ops:" + minOperations(new int[] {1,1,4,2,3}, 5));
        System.out.println("Min ops:" + minOperations(new int[] {5,6,7,8,9}, 4));
        System.out.println("Min ops:" + minOperations(new int[] {3,2,20,1,1,3}, 10));
    }
    public static int minOperations(int[] nums, int x) {
        int target = - x;
        for (int num : nums)
            target += num;
        int maxSize = Integer.MIN_VALUE, len = nums.length;
        int windowStart = 0, windowSum = 0;
        for (int windowEnd = 0; windowEnd < len; windowEnd++) {
            windowSum += nums[windowEnd];
            while (windowStart < len && windowSum > target) {
                windowSum -= nums[windowStart++];
            }
            if (windowSum == target)
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
        }
        return maxSize < 0 ? -1 : len - maxSize;
    }
}
