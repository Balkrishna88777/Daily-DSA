class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int[] count  = new int[1001];
        
        for(int r = 0; r < nums.length; r++) {
            for(int c = 0; c < nums[r].length; c++) {
                int i = nums[r][c];
                 count[i]++;
            }
        }
        
       for(int i=0;i<count.length;i++){
           if(count[i]==nums.length){
               ans.add(i);
           }
       }
        
        return ans;
    }
}