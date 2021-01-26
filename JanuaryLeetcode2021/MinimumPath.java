package JanuaryLeetcode2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPath {
    static int[] dirs = {0, 1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println("Max diff:" + minimumEffortPath(new int[][] {{1,2,2},{3,8,2},{5,3,5}}));
    }
    public static int minimumEffortPath(int[][] heights) {
        int rowLen = heights.length, colLen = heights[0].length;
        int[][] dist = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));
        minHeap.offer(new int[]{0, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int maxDiff = top[0], row = top[1], col = top[2];
            if (maxDiff > dist[row][col]) continue;
            if (row == rowLen - 1 && col == colLen - 1) return maxDiff;
            for (int i = 0; i < 4; i++) {
                int newRow = row + dirs[i], newCol = col + dirs[i + 1];
                if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen) {
                    int newDiff = Math.max(maxDiff, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (dist[newRow][newCol] > newDiff) {
                        dist[newRow][newCol] = newDiff;
                        minHeap.offer(new int[]{newDiff, newRow, newCol});
                    }
                }
            }

        }
        return 0;
    }
}
