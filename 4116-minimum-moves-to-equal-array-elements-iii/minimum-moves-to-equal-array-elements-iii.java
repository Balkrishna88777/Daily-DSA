class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(nums[i], max);
        }

        for(int i=0; i<nums.length; i++){
            int addo = max - nums[i];
            count+= addo;
        }

        return count;
    }
}