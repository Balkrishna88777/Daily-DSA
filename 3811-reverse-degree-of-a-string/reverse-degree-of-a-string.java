class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, 26 - (ch - 'a'));
        }

        for(int i=0; i<s.length(); i++){
            ans += map.get(s.charAt(i)) * (i+1);
        }

        return ans;
    }
}