package Amazon;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println("Two sum indices are:" + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Two sum indices are:" + Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
        System.out.println("Two sum indices are:" + Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        if (numbers == null || numbers.length == 0) return  indices;
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                indices[0] = lo + 1;
                indices[1] = hi + 1;
                break;
            }
            if (sum < target)
                lo++;
            else
                 hi--;
        }
        return indices;
    }
}
