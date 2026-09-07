class Solution {
    public int distinctSubseqII(String s) {

        long dp = 1;

        long[] last = new long[26];

        long MOD = 1000000007;

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            long newDp = (2 * dp - last[index] + MOD) % MOD;

            last[index] = dp;

            dp = newDp;
        }

        return (int)((dp - 1 + MOD) % MOD);
    }
}