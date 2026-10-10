class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int maxDiff = 0;

        int[] diff = new int[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }

        if (k >= total) {
            return 0;
        }

        int[] freq = new int[maxDiff + 1];

        for (int i = 0; i < n; i++) {
            freq[diff[i]]++;
        }

        while (k > 0 && maxDiff > 0) {
            if (freq[maxDiff] == 0) {
                maxDiff--;
                continue;
            }

            int moves = (int) Math.min(k, freq[maxDiff]);

            freq[maxDiff] -= moves;
            freq[maxDiff - 1] += moves;
            k -= moves;
        }

        long sum = 0;

        for (int i = 1; i < freq.length; i++) {
            sum += (long) i * i * freq[i];
        }

        return sum;
    }
}