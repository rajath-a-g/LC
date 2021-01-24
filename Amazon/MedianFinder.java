package Amazon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.max = new PriorityQueue<>();
        this.min = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size())
            max.offer(min.poll());
    }

    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return (double)max.peek();
    }
}
