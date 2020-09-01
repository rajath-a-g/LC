/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.ArrayList;
import java.util.List;

public class Leet872 {
    public void makeList(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);

        makeList(root.left, list);
        makeList(root.right, list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        makeList(root1, list1);
        makeList(root2, list2);
        return list1.equals(list2);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
