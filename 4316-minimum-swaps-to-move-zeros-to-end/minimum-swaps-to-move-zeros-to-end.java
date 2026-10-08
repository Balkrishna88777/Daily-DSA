class Solution {
    public int minimumSwaps(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;

        while(left < right){
            if(nums[right] == 0) right--;
            else if(nums[left] == 0 && nums[right] != 0){
                ans++;
                left++;
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}