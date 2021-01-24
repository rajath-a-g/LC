package Amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        System.out.println("Minimum number of meeting rooms:" + minMeetingRooms(new int[][] {{0,30},{5,10},{15,20}}));
        System.out.println("Minimum number of meeting rooms:" + minMeetingRooms(new int[][] {{7,10},{2,4}}));
    }
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] i : intervals) {
            if (!pq.isEmpty() && pq.peek()[1] < i[0])
                pq.poll();
            pq.add(i);
        }
        return pq.size();
    }
}
