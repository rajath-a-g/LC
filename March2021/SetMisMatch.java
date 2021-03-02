package March2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMisMatch {
    public static void main(String[] args) {
        System.out.println("Erronums are" + Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println("Erronums are" + Arrays.toString(findErrorNums(new int[]{1,1})));
    }
    public static int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = -1, len = nums.length;
        int sum = (len * (len + 1)) / 2;
        for (int num : nums) {
            if(!set.add(num)) dup = num;
            sum -= num;
        }
        return new int[] {dup, sum + dup};
    }
}
