package treeDs;

import java.util.Stack;

public class IterativePreOrder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        iterativePreOrder(root);
        System.out.println();
        iterativePreOrder2(root);
        System.out.println();
        iterativePreOrderSpaceOptimized(root);
    }

    public static void iterativePreOrder(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                System.out.print(stack.peek().data + " ");
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    public static void iterativePreOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    public static void iterativePreOrderSpaceOptimized(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.right != null)
                    stack.push(curr.right);
                curr = curr.left;
            }
            if (!stack.isEmpty())
                curr = stack.pop();
        }
    }
}
