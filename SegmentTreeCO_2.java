class SegmentTreeCO_2 {
    int[] tree;

    public SegmentTree(int[] arr) {
        int n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = Math.max(tree[2 * node],
                                  tree[2 * node + 1]);
        }
    }

    int query(int node, int start, int end,
              int l, int r) {

        if (r < start || end < l)
            return Integer.MIN_VALUE;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 3, 7};

        SegmentTree st = new SegmentTree(arr);

        int max = st.query(1, 0, arr.length - 1, 1, 4);

        System.out.println("Maximum Value in Range [1,4]: " + max);
    }
}
