class BPlusTreeNodeCO_2 {
    int[] keys = new int[10];
    int keyCount = 0;

    public void insert(int value) {
        keys[keyCount++] = value;
    }

    public void display() {
        System.out.println("B+ Tree Leaf Node Values:");
        for (int i = 0; i < keyCount; i++) {
            System.out.print(keys[i] + " ");
        }
    }
}

public class BPlusTreeDemo {
    public static void main(String[] args) {
        BPlusTreeNode root = new BPlusTreeNode();

        int[] values = {20, 40, 10, 30, 50, 60, 70};

        for (int value : values) {
            root.insert(value);
        }

        root.display();
    }
}
