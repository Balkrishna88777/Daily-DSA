class Solution {
    public int sortPermutation(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr);

        if(arr == nums) return 0;

        int ans = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != arr[i]){
                ans &= nums[i];
            }
        }
        return ans == -1 ? 0 : ans;
    }
}