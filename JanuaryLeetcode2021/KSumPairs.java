package JanuaryLeetcode2021;

import java.util.HashMap;
import java.util.Map;

public class KSumPairs {
    public static void main(String[] args) {
        System.out.println("Max ops:" + maxOperations(new int[] {1,2,3,4}, 5));
        System.out.println("Max ops:" + maxOperations(new int[] {3,1,3,4,3}, 6));
    }
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (freq.getOrDefault(k - num, 0) > 0) {
                freq.put(k - num, freq.get(k - num) - 1);
                res++;
            } else
                freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
