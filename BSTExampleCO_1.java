class BSTNode {
    int key;
    BSTNode left, right;

    BSTNode(int item) {
        key = item;
        left = right = null;
    }
}

public class BSTExampleCO_1 {
    BSTNode root;

    BSTNode insert(BSTNode root, int key) {
        if (root == null)
            return new BSTNode(key);

        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BSTExample tree = new BSTExample();

        int[] values = {10, 20, 30, 40, 50, 25};

        for (int val : values)
            tree.root = tree.insert(tree.root, val);

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);
    }
}
