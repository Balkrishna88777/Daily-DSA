class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k - 1;

        int sum = 0;

        for(int i=left; i<=right; i++){
            sum += nums[i];
        }
        int maxSum = sum;

        while(right < nums.length-1){
            sum = sum - nums[left];

            left++;
            right++;

            sum = sum + nums[right];

            maxSum = Math.max(maxSum, sum);
        }

        double ans = (double) maxSum / k;
        return ans;

    }
}