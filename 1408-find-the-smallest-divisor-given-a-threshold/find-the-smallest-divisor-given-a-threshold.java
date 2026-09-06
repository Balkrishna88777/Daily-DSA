class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int check = function(nums,mid,threshold);

            if(check <= threshold) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int function(int[] nums, int mid, int thres){
        int value = 0;
        for(int i=0; i<nums.length; i++){
            value += Math.ceil((double)nums[i]/(double)mid);
        }

        return value;
    }
}