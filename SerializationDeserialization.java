package treeDs;

import java.util.ArrayList;

public class SerializationDeserialization {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Index index = new Index(0);
        serialization(root, arrayList);
        for (int x : arrayList)
            System.out.print(x + " ");
        System.out.println();
        Node tree = deserialization(arrayList, index);
        preOrder(tree);
    }

    public static void serialization(Node root, ArrayList<Integer> arrayList) {
        if (root == null) {
            arrayList.add(-1);
            return;
        }
        arrayList.add(root.data);
        serialization(root.left, arrayList);
        serialization(root.right, arrayList);
    }

    public static Node deserialization(ArrayList<Integer> arrayList, Index index) {
        if (arrayList.size() == index.getIndex())
            return null;
        int value = arrayList.get(index.getIndex());
        index.setIndex(index.getIndex() + 1);
        if (value == -1)
            return null;
        Node root = new Node(value);
        root.left = deserialization(arrayList, index);
        root.right = deserialization(arrayList, index);
        return root;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

class Index {
    private int index;

    Index(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }
}