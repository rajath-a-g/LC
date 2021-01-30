package Amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static double curMedian = 0.0;
    static double[] runningMedian(int[] a) {
        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            addNum(a[i]);
            res[i] = getMedian();
        }
        return res;
    }

    static void addNum(int n) {
        if (n < curMedian)
            maxHeap.add(n);
        else
            minHeap.add(n);
        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size())
                minHeap.add(maxHeap.remove());
            else
                maxHeap.add(minHeap.remove());
        }
    }

    static double getMedian(){
        if (maxHeap.size() == minHeap.size())
            curMedian = (minHeap.peek() + maxHeap.peek()) / 2.0;
        else if (maxHeap.size() > minHeap.size())
            curMedian = maxHeap.peek();
        else
            curMedian = minHeap.peek();
        return curMedian;
    }
}
