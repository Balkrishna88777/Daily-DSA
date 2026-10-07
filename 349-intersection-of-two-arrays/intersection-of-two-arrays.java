class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            int num = nums1[i];
            set1.add(num);
        }

        for(int i=0; i<nums2.length; i++){
            int num = nums2[i];
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        int i = 0;

        int[] ans = new int[set2.size()];
        for (int num : set2) {
            ans[i] = num;
            i++;
        }
        return ans;
    }
}