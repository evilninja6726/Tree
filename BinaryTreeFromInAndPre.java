package treeDs;

public class BinaryTreeFromInAndPre {
    public static void main(String[] args) {
        Node root = binaryTreeFromInAndPre(new int[]{20, 10, 40, 30, 50}, new int[]{10, 20, 30, 40, 50}, 0, 4);
        preOrder(root);
    }

    static int preIndex = 0;

    public static Node binaryTreeFromInAndPre(int[] inOrder, int[] preOrder, int start, int end) {
        if (start > end)
            return null;
        Node root = new Node(preOrder[preIndex++]);
        int index = 0;
        for (int i = 0; i < preOrder.length; i++) {
            if (inOrder[i] == root.data) {
                index = i;
            }
        }
        root.left = binaryTreeFromInAndPre(inOrder, preOrder, start, index - 1);
        root.right = binaryTreeFromInAndPre(inOrder, preOrder, index + 1, end);
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
