package treeDs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right = new Node(30);
        root.right.right = new Node(60);
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().data + " ");
            if (queue.peek().left != null)
                queue.offer(queue.peek().left);
            if (queue.peek().right != null)
                queue.offer(queue.peek().right);
            queue.poll();
        }
    }
}
