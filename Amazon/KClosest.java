package Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {
    public static void main(String[] args) {
        System.out.println("K closest points to origin are:" + Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println("K closest points to origin are:" + Arrays.deepToString(kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pointPq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pointPq.add(point);
            if (pointPq.size() > K)
                pointPq.poll();
        }
        return pointPq.toArray(new int[K][]);
    }
}
