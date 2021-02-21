package treeDs;

public class MaximumInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right = new Node(30);
        root.right.right = new Node(60);
        System.out.println(maximumInBinaryTree(root));
    }

    public static int maximumInBinaryTree(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maximumInBinaryTree(root.left), maximumInBinaryTree(root.right)));
    }
}
