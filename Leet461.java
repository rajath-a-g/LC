/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.ArrayList;
import java.util.List;

public class Leet461 {
    public static void main(String[] args) {
        Leet461 leet461 = new Leet461();
        int res = leet461.hammingDistance(1, 4);
        System.out.println(res);
        int res1 = leet461.hammingDistance(4, 14);
        System.out.println(res1);
        int res3 = leet461.hammingDistance1(1, 4);
        System.out.println(res3);
        int res4 = leet461.hammingDistance1(4, 14);
        System.out.println(res4);
    }
    public int hammingDistance(int x, int y) {
        List<Integer> num1 = new ArrayList<>();
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        while (x > 0) {
            num1.add(x % 2);
            x = x >> 1;
        }
        int i = num1.size() - 1;
        int count = 0;
        while (y > 0 && i >= 0) {
            if (y % 2 != num1.get(i)) count++;
            i--;
            y /= 2;
        }
        if (y != 0) {
            while (y > 0) {
                if(y % 2 != 0) count++;
                y /= 2;
            }
        }
        return count;
    }
    public int hammingDistance1(int x, int y) {
        int res = x ^ y;
        int result = 0;
        while (res > 0) {
            if (res % 2 == 1) result++;
            res /= 2;
        }
        return result;
    }
}
