class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            int mod = num % k;

            long[] newDp = new long[k];

            newDp[mod]++;

            for (int r = 0; r < k; r++) {

                int newRemainder = (r * mod) % k;

                newDp[newRemainder] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;

    }
}