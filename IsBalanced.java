package treeDs;

public class IsBalanced {
    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(19);
        root.right.left = new Node(30);
        System.out.println(isBalanced(root));
        System.out.println(isBalancedEff(root));
    }

    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;
        return Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    public static int heightOfTree(Node root) {
        if (root == null)
            return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public static int isBalancedEff(Node root) {
        if (root == null)
            return 0;
        int leftHeight = isBalancedEff(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalancedEff(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
}
