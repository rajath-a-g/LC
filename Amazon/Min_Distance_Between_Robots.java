package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Min_Distance_Between_Robots {

    public static void main(String[] args)
    {
        Point[] points = new Point[7];

        points[0] = new Point(1, 1);
        points[1] = new Point(1, 9);
        points[2] = new Point(2, 5);
        points[3] = new Point(3, 1);
        points[4] = new Point(4, 4);
        points[5] = new Point(5, 8);
        points[6] = new Point(6, 2);

        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        System.out.println(divide(0, points.length-1, points));
    }

    public static double divide(int left, int right, Point[] points)
    {
        double curMinDis = 1e20;
        if (left == right)
        {
            return curMinDis;
        }

        if (left + 1 == right)
        {
            return distance(points[left], points[right]);
        }

        int middle = (left + right) / 2;
        double leftMinDis = divide(left, middle, points);
        double rightMinDis = divide(middle, right, points);

        curMinDis = Math.min(leftMinDis, rightMinDis);

        List<Integer> validPointIndex = new ArrayList<>();
        for (int i = left; i <= right; i++)
        {
            if (Math.abs(points[middle].x - points[i].x) <= curMinDis)
            {
                validPointIndex.add(i);
            }
        }

        for (int i = 0; i < validPointIndex.size() - 1; i++)
        {
            for (int j = i + 1; j < validPointIndex.size(); j++)
            {
                if (Math.abs(points[validPointIndex.get(i)].y
                        - points[validPointIndex.get(j)].y) > curMinDis)
                {
                    continue;
                }
                double tempDis = distance(points[validPointIndex.get(i)],
                        points[validPointIndex.get(j)]);

                curMinDis = Math.min(tempDis, curMinDis);
            }
        }

        return curMinDis;
    }

    public static double distance(Point p1, Point p2)
    {
        return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x));
    }

    static class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
