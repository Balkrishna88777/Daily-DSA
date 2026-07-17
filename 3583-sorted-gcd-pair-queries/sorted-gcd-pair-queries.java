import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        // cntDiv[d] = numbers divisible by d
        int[] cntDiv = new int[max + 1];

        for (int num : nums) {
            for (int d = 1; d * d <= num; d++) {
                if (num % d == 0) {
                    cntDiv[d]++;
                    if (d != num / d) {
                        cntDiv[num / d]++;
                    }
                }
            }
        }

        // gcdPairs[g] = number of pairs with gcd exactly g
        long[] gcdPairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long c = cntDiv[g];
            gcdPairs[g] = c * (c - 1) / 2;

            for (int multiple = g + g; multiple <= max; multiple += g) {
                gcdPairs[g] -= gcdPairs[multiple];
            }
        }

        // prefix[g] = pairs with gcd <= g
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + gcdPairs[g];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = lowerBound(prefix, queries[i] + 1);
        }

        return ans;
    }

    private int lowerBound(long[] prefix, long target) {
        int l = 1, r = prefix.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefix[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}