package treeDs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right = new Node(30);
        root.right.right = new Node(60);
        levelOrderLineByLine(root);
        System.out.println();
        System.out.println();
        levelOrderLineByLine2(root);
    }

    public static void levelOrderLineByLine(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (queue.size() > 1) {
            Node temp = queue.poll();
            if (temp == null) {
                System.out.println();
                queue.offer(null);
                continue;
            }
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
    }

    public static void levelOrderLineByLine2(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            System.out.println();
        }
    }
}
