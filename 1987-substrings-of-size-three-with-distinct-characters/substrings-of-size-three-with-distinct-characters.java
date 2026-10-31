class Solution {
    public int countGoodSubstrings(String s) {
        HashSet<Character> set = new HashSet<>();

        int count = 0;

        for(int l=0; l<s.length()-2; l++){
            int r = l + 2;

            set.add(s.charAt(l));
            set.add(s.charAt(l+1));
            set.add(s.charAt(r));

            if(set.size() == 3) count++;

            set.clear();
        }

        return count;
    }
}