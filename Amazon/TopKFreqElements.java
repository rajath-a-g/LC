package Amazon;

import java.util.*;

public class TopKFreqElements {
    public static void main(String[] args) {
        System.out.println("Top k frequent elements are:" + Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
        System.out.println("Top k frequent elements are:" + Arrays.toString(topKFrequent(new int[] {1}, 1)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        for (int n : freq.keySet()) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}
