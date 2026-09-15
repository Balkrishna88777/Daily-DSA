class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
       
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            char c = pq.poll();
            
            for(int i=0; i<map.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}