/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.Arrays;

public class Leet179 {
    public static void main(String[] args) {
        Leet179 leet179 = new Leet179();
        int[] num1 = {10, 2};
        System.out.println(leet179.largestNumber(num1));
        int[] num2 = {3, 30, 34, 5, 9};
        System.out.println(leet179.largestNumber(num2));
    }
    public String largestNumber(int[] nums) {
        String[] num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(num, (s1, s2) -> ((s2 + s1).compareTo(s1 + s2)));
        String res = String.join("", num);
        if (res.isEmpty() || res.charAt(0) == '0')
            return "0";
        return res;
    }
}
