import java.util.HashSet;
import java.util.Set;

/*
 * Copyright (c) 2020 Author: Rajath
 */

public class Leet653 {
    public static void main(String[] args) {
        Leet653 leet653 = new Leet653();
        boolean res = leet653.findTarget(new TreeNode(), 9);
        System.out.println(res);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> res = new HashSet<>();
        return find(root, k, res);
    }

    private boolean find(TreeNode root, int target, Set<Integer> res) {
        if (root == null) return false;
        if (res.contains(target - root.val)) return true;
        res.add(root.val);
        return find(root.left, target, res) || find(root.right, target, res);
    }
}
