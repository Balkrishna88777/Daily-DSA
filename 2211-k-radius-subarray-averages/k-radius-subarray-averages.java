class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        java.util.Arrays.fill(ans, -1);

        if (k == 0) {
            return nums;
        }

        for (int i = 0; i < n; i++) {

            if (i < k || i + k >= n) {
                continue;
            }

            long sum = 0;
            int div = 0;

            for (int j = i - k; j <= i + k; j++) {
                sum += nums[j];
                div++;
            }

            ans[i] = (int)(sum / div);
        }

        return ans;
    }
}