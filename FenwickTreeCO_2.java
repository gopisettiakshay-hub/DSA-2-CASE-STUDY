class FenwickTreeCO_2 {
    int[] BIT;
    int n;

    public FenwickTree(int size) {
        n = size;
        BIT = new int[n + 1];
    }

    void update(int index, int value) {
        index++;

        while (index <= n) {
            BIT[index] += value;
            index += index & (-index);
        }
    }

    int getSum(int index) {
        index++;
        int sum = 0;

        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }

        return sum;
    }

    int rangeSum(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }

    public static void main(String[] args) {
        int[] freq = {1, 3, 5, 7, 9};

        FenwickTree ft = new FenwickTree(freq.length);

        for (int i = 0; i < freq.length; i++) {
            ft.update(i, freq[i]);
        }

        int result = ft.rangeSum(1, 3);

        System.out.println("Cumulative Sum from Index [1,3]: " + result);
    }
}
