package treeDs;

public class LargestDiameter {
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(60);
        root.right.left.left=new Node(50);
        root.right.right.right=new Node(70);
        root.right.right.right.right=new Node(80);
        root.right.right.right.right.right=new Node(90);
        System.out.println(largestDiameter(root));
        System.out.println(largestDiameterEff(root));
        System.out.println(maxDiameter);
    }
    public static int largestDiameter(Node root){
        if (root==null)
            return 0;
        int rootDiameter=height(root.left)+height(root.right)+1;
        int leftDiameter=largestDiameter(root.left);
        int rightDiameter=largestDiameter(root.right);
        return Math.max(rootDiameter,Math.max(rightDiameter,leftDiameter));
    }

    public static int height(Node root){
        if (root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    static int maxDiameter=0;
    public static int largestDiameterEff(Node root){
        if (root==null)
            return 0;
        int lh=largestDiameterEff(root.left);
        int rh=largestDiameterEff(root.right);
        maxDiameter=Math.max(maxDiameter,1+lh+rh);
        return 1+Math.max(rh,lh);
    }
}
