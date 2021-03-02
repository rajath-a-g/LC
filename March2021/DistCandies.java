package March2021;

import java.util.HashSet;

public class DistCandies {
    public static void main(String[] args) {
        System.out.println("Types that can be distributed:" + distributeCandies(new int[] {1,1,2,2,3,3}));
        System.out.println("Types that can be distributed:" + distributeCandies(new int[] {1,1,2,3}));
        System.out.println("Types that can be distributed:" + distributeCandies(new int[] {6,6,6,6}));
    }
    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>();
        for (int candy : candyType) {
            if (!types.contains(candy))
                types.add(candy);
        }
        return Math.min(candyType.length / 2, types.size());
    }
}
