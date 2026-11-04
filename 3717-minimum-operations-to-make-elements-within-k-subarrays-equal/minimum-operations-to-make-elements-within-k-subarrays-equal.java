class Solution {

    // Maintains the median and cost of a sliding window
    static class MedianWindow {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        void add(int num) {
            if (low.isEmpty() || num <= low.lastKey()) {
                low.merge(num, 1, Integer::sum);
                lowSize++;
                lowSum += num;
            } else {
                high.merge(num, 1, Integer::sum);
                highSize++;
                highSum += num;
            }
            balance();
        }

        void remove(int num) {
            if (low.containsKey(num)) {
                removeFrom(low, num);
                lowSize--;
                lowSum -= num;
            } else {
                removeFrom(high, num);
                highSize--;
                highSum -= num;
            }
            balance();
        }

        void removeFrom(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {
            while (lowSize > highSize + 1) {
                int val = low.lastKey();
                removeFrom(low, val);
                lowSize--;
                lowSum -= val;

                high.merge(val, 1, Integer::sum);
                highSize++;
                highSum += val;
            }

            while (lowSize < highSize) {
                int val = high.firstKey();
                removeFrom(high, val);
                highSize--;
                highSum -= val;

                low.merge(val, 1, Integer::sum);
                lowSize++;
                lowSum += val;
            }
        }

        long getCost() {
            long median = low.lastKey();

            long leftCost = median * lowSize - lowSum;
            long rightCost = highSum - median * highSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++) {

            window.add(nums[i]);

            if (i >= x) {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }

        // Step 2: Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        // dp[j][i] = minimum cost to select j
        // non-overlapping windows in first i elements

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element
                dp[j][i] = dp[j][i - 1];

                // Option 2: Select window ending at i-1
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long take = dp[j - 1][i - x]
                                + cost[i - x];

                    dp[j][i] = Math.min(dp[j][i], take);
                }
            }
        }

        return dp[k][n];
    }
}
