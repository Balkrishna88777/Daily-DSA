class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if(first != second){
                int addo = Math.abs(first - second);
                maxHeap.offer(addo);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }

        return maxHeap.poll();
    }
}