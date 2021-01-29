package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    class Node {
        int data;
        Node left;
        Node right;
    }
    public static void levelOrder(Node root) {
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()) {
            Node newNode = bfs.poll();
            System.out.println(newNode.data + " ");
            bfs.offer(newNode.left);
            bfs.offer(newNode.right);
        }
    }
}
