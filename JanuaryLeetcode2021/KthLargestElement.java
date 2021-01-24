package JanuaryLeetcode2021;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println("Kth largest is:" + findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println("Kth largest is:" + findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++)
            pq.add(nums[i]);

        while(k-- > 1){
            pq.remove();
        }
        return pq.remove();
    }
}
