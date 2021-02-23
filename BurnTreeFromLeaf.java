package treeDs;

public class BurnTreeFromLeaf {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        Distance distance = new Distance(-1);
        System.out.println(time);
        System.out.println(burnTreeFromLeaf(root, 50, distance));
        System.out.println(time);
    }

    static int time = 0;

    public static int burnTreeFromLeaf(Node root, int leaf, Distance distance) {
        if (root == null)
            return 0;
        if (root.data == leaf) {
            distance.setValue(0);
            return 1;
        }
        Distance leftDistance = new Distance(-1);
        Distance rightDistance = new Distance(-1);
        int leftHeight = burnTreeFromLeaf(root.left, leaf, leftDistance);
        int rightHeight = burnTreeFromLeaf(root.right, leaf, rightDistance);
        if (leftDistance.getValue() != -1) {
            distance.setValue(leftDistance.getValue() + 1);
            time = Math.max(time, distance.getValue() + rightHeight);
        } else if (rightDistance.getValue() != -1) {
            distance.setValue(rightDistance.getValue() + 1);
            time = Math.max(time, distance.getValue() + leftHeight);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class Distance {
    private int value;

    Distance(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }

    void setValue(int data) {
        value = data;
    }
}