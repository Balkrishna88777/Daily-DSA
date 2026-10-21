class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = 1 << n;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<subsets; i++){
            List<Integer> addo = new ArrayList<>();
            for(int num = 0; num<n; num++){
                if((i & (1 << num)) != 0){
                    addo.add(nums[num]);
                }
            }
            ans.add(addo);
        }
        return ans;
    }
}