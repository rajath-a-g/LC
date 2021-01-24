package Amazon;

import java.util.*;

public class MinDistanceRobots {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static long closesSquaredDistance(int numRobots, List<Integer> positionX, List<Integer> positionY) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < numRobots; i++) {
            points.add(new Point(positionX.get(i), positionY.get(i)));
        }
        List<Point> yPoints = new ArrayList<>(points);
        points.sort(Comparator.comparingInt(a -> a.x));
        yPoints.sort(Comparator.comparingInt(a -> a.y));
        return closestUtil(points, yPoints, numRobots);
    }

    private static long closestUtil(List<Point> xPoints, List<Point> yPoints, int n) {
        if (n <= 3)
            return bruteForce(xPoints, n);
        int mid = n / 2;
        Point midPoint = xPoints.get(mid);
        long dl = closestUtil(xPoints.subList(0, mid), yPoints, mid);
        long dr = closestUtil(xPoints.subList(mid, xPoints.size()), yPoints, n - mid);

        long d = Math.min(dl, dr);
        List<Point> neighbours = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(yPoints.get(i).x - midPoint.x) < d)
                neighbours.add(yPoints.get(i));
        }
        return Math.min(d, getClosestDistance(neighbours.toArray(new Point[neighbours.size()]), d));

    }

    private static long bruteForce(List<Point> points, int n) {
        long min_value = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long val = calculateDist(points.get(i), points.get(j));
                if (val < min_value)
                    min_value = val;
            }
        }
        return min_value;
    }

    private static long calculateDist(Point p1, Point p2) {
        return (long)Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));
    }

    private static long getClosestDistance(Point[] neigh, long d) {
        long min_value = d;
        for (int i = 0; i < neigh.length; i++) {
            int j = i + 1;
            while (j < neigh.length && ((neigh[j].y - neigh[i].y) < min_value)) {
                min_value = calculateDist(neigh[i], neigh[j]);
                j++;
            }
        }
        return min_value;
    }

    public static void main(String[] args) {
        int[] xCoordArr1 = new int[] {2,12,40,5,12,3};
        List<Integer> xCoord1 = new ArrayList<>();
        for (int num : xCoordArr1)
            xCoord1.add(num);
        int[] yCoordArr1 = new int[] {3,30,50,1,10,4};
        List<Integer> yCoord1 = new ArrayList<>();
        for (int num : yCoordArr1)
            yCoord1.add(num);
        long startTime1 = System.nanoTime();
        System.out.println("Closest squared distance is:" + closesSquaredDistance(6, xCoord1, yCoord1));
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("Time taken:" + estimatedTime1/1000000);
        int[] xCoordArr2 = new int[] {1,1,2,3,4,5,6};
        List<Integer> xCoord2 = new ArrayList<>();
        for (int num : xCoordArr2)
            xCoord2.add(num);
        int[] yCoordArr2 = new int[] {1,9,5,1,4,8,2};
        List<Integer> yCoord2 = new ArrayList<>();
        for (int num : yCoordArr2)
            yCoord2.add(num);
        long startTime = System.nanoTime();
        System.out.println("Closest squared distance is:" + closesSquaredDistance(7, xCoord2, yCoord2));
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time taken:" + estimatedTime);

    }
}
