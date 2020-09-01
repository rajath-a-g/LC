/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetSingleNumber {
    public static void main(String[] args) {
        LeetSingleNumber leetSingleNumber = new LeetSingleNumber();
        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] res = leetSingleNumber.singleNumber(nums1);
        System.out.println(Arrays.toString(res));
    }
    public int[] singleNumber(int[] nums) {
        List<Integer> single = new ArrayList<>();
        for (int num : nums) {
            if (single.contains(num)) single.remove(((Integer)num));
            else single.add(num);
        }
        return single.stream().mapToInt(i->i).toArray();
    }
}
