/*
 * Copyright (c) 2020 Author: Rajath
 */

public class Leet190 {
    public static void main(String[] args) {
        Leet190 leet190 = new Leet190();
        int n = 43261596;
        System.out.println("Result = " + leet190.reverseBits(n));
    }
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println("Result in loop:" + result);
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
            System.out.println("N in loop:" + n);
        }
        return result;
    }
}
