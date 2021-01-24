package Amazon;

import java.util.*;

class Solution {
    public static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel) {
        int numSkills = 0;
        for (int skill : skills) {
            if (skill >= minLevel && skill <= maxLevel)
                numSkills++;
        }
        return nCr(numSkills, minAssociates) + 1;
    }

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countTeams(6, new int[]{12, 4, 6, 13, 5, 10}, 3, 4, 10));
    }
}
