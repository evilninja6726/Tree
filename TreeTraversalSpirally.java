package treeDs;

import java.util.*;

public class TreeTraversalSpirally {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        treeTraversalSpirally(root);
        System.out.println();
        treeTraversalSpirallyEff(root);
    }

    public static void treeTraversalSpirally(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Node temp = queue.poll();
                if (!flag)
                    stack.push(temp.data);
                else
                    System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            if (!flag) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
            flag = !flag;
        }
    }

    public static void treeTraversalSpirallyEff(Node root) {
        if (root == null)
            return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    s2.push(temp.left);
                if (temp.right != null)
                    s2.push(temp.right);
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null)
                    s1.push(temp.right);
                if (temp.left != null)
                    s1.push(temp.left);
            }
        }
    }
}
