class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int ans = Integer.highestOneBit(n) << 1;
        return ans;
    }
}