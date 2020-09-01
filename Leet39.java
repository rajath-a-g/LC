/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet39 {
    public static void main(String[] args) {
        Leet39 leet39 = new Leet39();
        int test1[] = {2, 3, 6, 7};
        List<List<Integer>> res = new ArrayList<>();
        res = leet39.combinationSum(test1, 7);
        System.out.println(Arrays.deepToString(res.toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(res, temp, candidates, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
