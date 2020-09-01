/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.Arrays;
import java.util.Comparator;

public class Leet1029 {
    public static void main(String[] args) {
        Leet1029 leet1029 = new Leet1029();
        int[][] cost1 = {{10,20},{30,200},{400,50},{30,20}};
        int res = leet1029.twoCitySchedCost(cost1);
        System.out.println(res);
    }
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length - i - 1][0];
        }
        return cost;
    }
}
