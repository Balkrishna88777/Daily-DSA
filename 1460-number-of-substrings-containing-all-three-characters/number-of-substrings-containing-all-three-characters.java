class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] ls = new int[3];
        Arrays.fill(ls, -1);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            ls[ch - 'a'] = i;

            if(ls[0] != -1 && ls[1] != -1 && ls[2] != -1){
                count = count + Math.min(ls[0], Math.min(ls[1], ls[2])) + 1;
            }
        }
        return count;
    }
}