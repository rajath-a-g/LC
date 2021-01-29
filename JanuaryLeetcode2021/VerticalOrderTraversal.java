package JanuaryLeetcode2021;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Vertical order is " + verticalTraversal(root));
    }
    static Map<Integer, TreeMap<Integer, List<Integer>>> orderMap = new TreeMap<>(Comparator.naturalOrder());
     public static class TreeNode {
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

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        addElements(root, 0, 0);
        List<List<Integer>> vertical = new ArrayList<>();
        for (int col : orderMap.keySet()) {
            List<Integer> levelOrder = new ArrayList<>();
            for (List<Integer> list : orderMap.get(col).values()) {
                Collections.sort(list);
                levelOrder.addAll(list);
            }
            vertical.add(levelOrder);
        }
        return vertical;
    }

    private static void addElements(TreeNode node, int col, int row) {
         if (node == null)
             return;
         orderMap.putIfAbsent(col, new TreeMap<>());
         orderMap.get(col).putIfAbsent(row, new ArrayList<>());
         orderMap.get(col).get(row).add(node.val);
         addElements(node.left, col - 1, row + 1);
         addElements(node.right, col + 1, row + 1);
    }
}
