package treeDs;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right = new Node(30);
        root.right.right = new Node(60);
        leftViewOfBinaryTree(root, 1);
        System.out.println();
        leftViewOfBinaryTreeIt(root);
    }

    static int maxLevel = 0;

    public static void leftViewOfBinaryTree(Node root, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        leftViewOfBinaryTree(root.left, level + 1);
        leftViewOfBinaryTree(root.right, level + 1);
    }

    public static void leftViewOfBinaryTreeIt(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Node temp = queue.poll();
                if (i == 0)
                    System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
        }
    }
}
