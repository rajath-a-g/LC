package Amazon;

import java.util.Stack;

class TreNode {
    int val;
    TreNode left;
    TreNode right;

    TreNode(int val) {
        this.val = val;
    }

    TreNode(int val, TreNode left, TreNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBST {
    public static void main(String[] args) {
        TreNode case1 = new TreNode(2, new TreNode(1), new TreNode(3));
        System.out.println("Valid BST ? " + isValidBST(case1));
        TreNode case2 = new TreNode(5, new TreNode(1), new TreNode(4, new TreNode(3), new TreNode(6)));
        System.out.println("Valid BST? " + isValidBST(case2));
    }

    public static boolean isValidBST(TreNode root) {
        if (root == null) return true;
        Stack<TreNode> stack = new Stack<>();
        TreNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
