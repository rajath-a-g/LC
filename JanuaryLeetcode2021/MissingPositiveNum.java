package JanuaryLeetcode2021;

import java.util.ArrayList;
import java.util.List;

public class MissingPositiveNum {
    public static void main(String[] args) {
        System.out.println("Missing:" + findKthPositive(new int[] {2,3,4,7,11}, 5));
        System.out.println("Missing:" + findKthPositive(new int[] {1,2,3,4}, 2));
    }
    public static int findKthPositive(int[] arr, int k) {
        List<Integer> missing = new ArrayList<>();
        int i = 0; int j = 0;
        while (j < arr.length && missing.size() != k) {
            if (arr[j] != i + 1)
                missing.add(i + 1);
            else
                j++;
            i++;
        }
        if(j == arr.length)
            return arr[arr.length - 1] + k;
        return missing.get(missing.size() - 1);
    }

    // Use binary search
}
