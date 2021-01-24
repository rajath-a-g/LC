package Grokking.TwoPointer;

import java.util.Arrays;

public class twosum2 {
    public static void main(String[] args) {
        System.out.println("Indexes of 2sum are:" + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Indexes of 2sum are:" + Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println("Indexes of 2sum are:" + Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1, sum = 0;
        while (lo < hi) {
            sum = numbers[lo] + numbers[hi];
            if ( sum == target)
                return new int[] {lo + 1, hi + 1};
            if (sum < target)
                lo++;
            else
                hi--;
        }
        return new int[] {-1, -1};
    }
}
