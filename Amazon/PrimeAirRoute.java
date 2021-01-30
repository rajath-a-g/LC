package Amazon;

import java.util.*;

public class PrimeAirRoute {

    public static void main(String[] args) {
        // sample input
        System.out.println(getIdPairsForOptimal(
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000),
                        Arrays.asList(4, 10000)),
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 9000), Arrays.asList(3, 5000)), 10000));
    }

    public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardList,
                                                           List<List<Integer>> backwardList, int maxDistance) {
        forwardList.sort(Comparator.comparingInt(a -> a.get(1)));
        backwardList.sort(Comparator.comparingInt(a -> a.get(1)));
        int i = 0, j = backwardList.size() - 1;
        int max = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        while (i < forwardList.size() && j >= 0) {
            int curDist = forwardList.get(i).get(1) + backwardList.get(j).get(1);
            if (curDist <= maxDistance && curDist > max) {
                result.clear();// reset list
                max = curDist;
                result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
                i++;
            } else if (curDist == max) {
                result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
                i++;
            } else {
                j--;
            }
        }
        return result;
//        List<List<Integer>> result = new LinkedList<>();
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < forwardList.size(); i++) {
//            for (int j = 0; j < backwardList.size(); j++) {
//                int cmax = forwardList.get(i).get(1) + backwardList.get(j).get(1);
//                if (cmax <= maxDistance) {
//                    if (cmax > max) {
//                        max = cmax;
//                        result = new ArrayList<>();
//                        result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
//                    } else if (cmax == max) {
//                        result.add(Arrays.asList(forwardList.get(i).get(0), backwardList.get(j).get(0)));
//                    }
//
//                }
//            }
//        }
//        return result;
    }
}
