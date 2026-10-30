class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, r = 0, l = 0, sero = 0;

        while(r < nums.length){
            if(nums[r] == 0) sero++;

            while(sero > k){
                if(nums[l] == 0) sero--;
                l++;
            }

            if(sero <= k){
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }

            r++;
        }
        return maxLen;
    }
}