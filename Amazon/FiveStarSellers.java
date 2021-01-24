package Amazon;

import java.util.*;

public class FiveStarSellers {
    public static void main(String[] args) {
        List<List<Integer>> productRatings1 = new ArrayList<>();
        productRatings1.add(Arrays.asList(4, 4));
        productRatings1.add(Arrays.asList(1, 2));
        productRatings1.add(Arrays.asList(3, 6));
        System.out.println("Additional reviews:" + fiveStarSellers(productRatings1, 77));
    }

    public static int fiveStarSellers(List<List<Integer>> productRatings, int ratingsThreshold) {
        if (productRatings == null || productRatings.size() == 0)
            return 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            double res1 = ((a.get(0) + 1) / (a.get(1) + 1));
            double res2 = ((b.get(0) + 1)) / (a.get(1) + 1);
            return Double.compare(res1, res2);
        });
        pq.addAll(productRatings);
        double sum = 0;
        int numRatings = 0;
        for (List<Integer> list : pq) {
            //System.out.println("Lists are" + list);
            sum += ((double)list.get(0) / (double)list.get(1));
        }
        int n = productRatings.size();
        double threshold = (sum / n) * 100;
        //System.out.println("Threshold first:" + threshold + sum);
        while(threshold < ratingsThreshold) {
            List<Integer> smallestRatio = pq.poll();
            //System.out.println("Got from pq:" + smallestRatio);
            sum -= ((double)smallestRatio.get(0) / (double)smallestRatio.get(1));
            smallestRatio.set(0, smallestRatio.get(0) + 1);
            smallestRatio.set(1, smallestRatio.get(1) + 1);
            pq.add(smallestRatio);
            sum += ((double)smallestRatio.get(0) / (double)smallestRatio.get(1));
            threshold = (sum / n) * 100;
            numRatings++;
        }
        return numRatings;
    }
}
