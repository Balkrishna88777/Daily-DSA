class Solution {

    static final int MOD = 1_000_000_007;

    long[] sum;
    long[] square;
    long[] lazy;

    public int sumCounts(int[] nums) {

        int n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        HashMap<Integer, Integer> last = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int prev = last.getOrDefault(nums[i], -1);

            update(1, 0, n - 1, prev + 1, i);

            last.put(nums[i], i);

            ans = (ans + query(1, 0, n - 1, 0, i)) % MOD;
        }

        return (int) ans;
    }

    void update(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {

            int len = r - l + 1;

            square[node] =
                (square[node] + 2 * sum[node] + len) % MOD;

            sum[node] =
                (sum[node] + len) % MOD;

            lazy[node]++;

            return;
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        if (ql <= mid) {
            update(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            update(node * 2 + 1, mid + 1, r, ql, qr);
        }

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        square[node] =
            (square[node * 2] + square[node * 2 + 1]) % MOD;
    }

    void push(int node, int l, int r) {

        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = (l + r) / 2;
        long val = lazy[node];

        apply(node * 2, l, mid, val);
        apply(node * 2 + 1, mid + 1, r, val);

        lazy[node] = 0;
    }

    void apply(int node, int l, int r, long val) {

        int len = r - l + 1;

        square[node] =
            (square[node]
            + 2 * val % MOD * sum[node]
            + val * val % MOD * len) % MOD;

        sum[node] =
            (sum[node] + val * len) % MOD;

        lazy[node] =
            (lazy[node] + val) % MOD;
    }

    long query(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            return square[node];
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        long ans = 0;

        if (ql <= mid) {
            ans += query(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            ans += query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        return ans % MOD;
    }
}