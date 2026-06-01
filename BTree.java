class BTreeNode {
    int[] keys;
    int t;
    BTreeNode[] children;
    int n;
    boolean leaf;

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        n = 0;
    }

    public void traverse() {
        int i;
        for (i = 0; i < n; i++) {
            if (!leaf)
                children[i].traverse();
            System.out.print(keys[i] + " ");
        }

        if (!leaf)
            children[i].traverse();
    }

    public void insertNonFull(int key) {
        int i = n - 1;

        if (leaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }

            keys[i + 1] = key;
            n++;
        } else {
            while (i >= 0 && keys[i] > key)
                i--;

            if (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, children[i + 1]);

                if (keys[i + 1] < key)
                    i++;
            }
            children[i + 1].insertNonFull(key);
        }
    }

    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++)
            z.keys[j] = y.keys[j + t];

        if (!y.leaf) {
            for (int j = 0; j < t; j++)
                z.children[j] = y.children[j + t];
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--)
            children[j + 1] = children[j];

        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--)
            keys[j + 1] = keys[j];

        keys[i] = y.keys[t - 1];
        n++;
    }
}

class BTree {
    BTreeNode root;
    int t;

    public BTree(int t) {
        this.t = t;
        root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);

                int i = 0;
                if (s.keys[0] < key)
                    i++;

                s.children[i].insertNonFull(key);
                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    public void traverse() {
        if (root != null)
            root.traverse();
    }

    public static void main(String[] args) {
        BTree tree = new BTree(2);

        int[] values = {20, 40, 10, 30, 50, 60, 70};

        for (int val : values)
            tree.insert(val);

        System.out.println("B-Tree Traversal:");
        tree.traverse();
    }
}