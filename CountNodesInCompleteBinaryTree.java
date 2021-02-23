package treeDs;

public class CountNodesInCompleteBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.left.left = new Node(15);
        root.left.left.right = new Node(25);
        root.left.right = new Node(50);
        root.left.right.left = new Node(80);
        root.left.right.right = new Node(90);
        root.right = new Node(30);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        System.out.println(countNodesInCompleteBinaryTree(root));
        System.out.println(countNodesInCompleteBinaryTreeEff(root));

        System.out.println(power(4, 4));
    }

    public static int countNodesInCompleteBinaryTree(Node root) {
        if (root == null)
            return 0;
        return countNodesInCompleteBinaryTree(root.left) + countNodesInCompleteBinaryTree(root.right) + 1;
    }

    public static int countNodesInCompleteBinaryTreeEff(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh)
            return power(2, lh) - 1;
        else
            return 1 + countNodesInCompleteBinaryTreeEff(root.left) + countNodesInCompleteBinaryTreeEff(root.right);
    }

    static int power(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i++)
            res *= x;
        return res;
    }
}
