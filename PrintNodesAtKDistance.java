package treeDs;

public class PrintNodesAtKDistance {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right = new Node(30);
        root.right.right = new Node(60);
        printNodesAtKDistance(root, 4);
        System.out.println();
        printNodesAtKDistance(root, 3);
        System.out.println();
        printNodesAtKDistance(root, 2);
        System.out.println();
        printNodesAtKDistance(root, 1);
    }

    public static void printNodesAtKDistance(Node root, int k) {
        if (root == null)
            return;
        if (k == 1)
            System.out.print(root.data + " ");
        printNodesAtKDistance(root.left, k - 1);
        printNodesAtKDistance(root.right, k - 1);
    }
}
