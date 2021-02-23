package treeDs;

import java.util.ArrayList;

public class LCA {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(80);
        root.right = new Node(30);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        System.out.println(lca(root, 60, 80).data);
        System.out.println(lcaEff(root, 70, 60).data);
    }

    public static Node lca(Node root, int x, int y) {
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();
        if (!findPath(root, p1, x) || !findPath(root, p2, y))
            return null;
        for (int i = 0; i < p1.size() - 1 && i < p2.size() - 1; i++) {
            if (p1.get(i + 1) != p2.get(i + 1))
                return p1.get(i);
        }
        return null;
    }

    public static boolean findPath(Node root, ArrayList<Node> arrayList, int n) {
        if (root == null)
            return false;
        arrayList.add(root);
        if (root.data == n)
            return true;
        if (findPath(root.left, arrayList, n) || findPath(root.right, arrayList, n))
            return true;
        arrayList.remove(arrayList.size() - 1);
        return false;
    }

    public static Node lcaEff(Node root, int x, int y) {
        if (root == null)
            return null;
        if (root.data == x || root.data == y)
            return root;
        Node left = lcaEff(root.left, x, y);
        Node right = lcaEff(root.right, x, y);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        else
            return right;
    }
}
