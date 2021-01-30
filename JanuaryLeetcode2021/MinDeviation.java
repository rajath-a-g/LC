package JanuaryLeetcode2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinDeviation {
    public static void main(String[] args) {
        System.out.println("MinDeviation is " + minimumDeviation(new int[] {1,2,3,4}));
        System.out.println("MinDeviation is " + minimumDeviation(new int[] {4,1,5,20,3}));
        System.out.println("MinDeviation is " + minimumDeviation(new int[] {2,10,8}));
    }
    public static int minimumDeviation(int[] nums) {
        List<Integer> input = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                input.add(num);
                min = Math.min(min, num);
            } else {
                input.add(num * 2);
                min = Math.min(min, num * 2);
            }
        }
        PriorityQueue<Integer> indicator = new PriorityQueue<>(Collections.reverseOrder());
        indicator.addAll(input);
        int minDeviation = Integer.MAX_VALUE;
        while (!indicator.isEmpty()) {
            int cur = indicator.poll();
            minDeviation = Math.min(minDeviation, cur - min);
            if (cur % 2 == 0) {
                indicator.offer(cur / 2);
                min = Math.min(min, cur / 2);
            } else {
                break;
            }
        }
        return minDeviation;
    }
}
