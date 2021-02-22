package treeDs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        System.out.println(maxWidth(root));
    }

    public static int maxWidth(Node root) {
        if (root == null)
            return 0;
        int maxWidth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int width = queue.size();
            maxWidth = Math.max(width, maxWidth);
            for (int i = 0; i < width; i++) {
                Node temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
        }
        return maxWidth;
    }
}
