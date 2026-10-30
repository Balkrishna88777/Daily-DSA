class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0, maxLen = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while(r < n){
            char ch = s.charAt(r);

            if(hash[ch] != -1){
                if(hash[ch] >= l){
                    l = hash[ch] + 1;
                }
            }

            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            hash[ch] = r;
            r++;
        }
        return maxLen;
    }
}