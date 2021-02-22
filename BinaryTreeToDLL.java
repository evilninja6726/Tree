package treeDs;

public class BinaryTreeToDLL {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        Node head = binaryTreeToDLL(root);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    static Node prev = null;

    public static Node binaryTreeToDLL(Node root) {
        if (root == null)
            return root;
        Node head = binaryTreeToDLL(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryTreeToDLL(root.right);
        return head;
    }
}
