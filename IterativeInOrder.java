package treeDs;

import java.util.Stack;

public class IterativeInOrder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        iterativeInorder(root);
    }

    public static void iterativeInorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            System.out.print(stack.peek().data + " ");
            curr = stack.pop();
            curr = curr.right;
        }
    }
}
