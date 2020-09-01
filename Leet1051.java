/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.Arrays;

public class Leet1051 {
    public static void main(String[] args) {
        Leet1051 leet1051 = new Leet1051();
        int[] test1 = {1,1,4,2,1,3};
        int result = leet1051.heightChecker(test1);
        System.out.println(result);
    }
    public int heightChecker(int[] heights) {
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (arr[i] != heights[i]) count++;
        }
        return count;
    }
}
