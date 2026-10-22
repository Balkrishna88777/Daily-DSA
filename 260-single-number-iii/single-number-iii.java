class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int i=0;

        for (int num : nums) {
            if (map.get(num) == 1) {
                ans[i] = num;
                i++;
            }
        }
        return ans;
    }
}