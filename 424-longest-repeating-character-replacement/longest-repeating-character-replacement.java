class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r = 0, maxLen = 0, maxfreq = 0;
        int[] hash = new int[26];

        while(r < s.length()){
            char ch = s.charAt(r);

            hash[ch - 'A']++;
            maxfreq = Math.max(maxfreq, hash[ch - 'A']);

            while((r-l+1) - maxfreq > k){
                hash[s.charAt(l)-'A']--;
                maxfreq = 0;
                for(int i=0; i<26; i++){
                    maxfreq = Math.max(maxfreq, hash[i]);
                }
                l++;
            }
           
            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }
        return maxLen;
    }
}