class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i),0)+1);
        }

        for (char ch : map.keySet()) {
            map.put(ch, map.get(ch) - 1);
            HashSet<Integer> set = new HashSet<>();
            for (int freq : map.values()) {
                if (freq > 0) {
                    set.add(freq);
                }
            }
            if (set.size() == 1) {
                return true;
            }
            map.put(ch, map.get(ch) + 1);
        }
        return false;
    }
}