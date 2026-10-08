class Solution {
    public List<Integer> findPeaks(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1; i<nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                ans.add(i);
            }
        }
        return ans;
    }
}