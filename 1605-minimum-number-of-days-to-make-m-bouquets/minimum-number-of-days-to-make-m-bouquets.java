class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m * k > bloomDay.length) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i < bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        // for(int i=min; i<=max; i++){
        //     if(possible(bloomDay, i, m, k)) return i;
        // }

        int low = min;
        int high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean possible(int[] bloomDay, int Day, int m, int k){
        int count = 0;
        int NBouq = 0;

        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= Day){
                count++;
            }else{
                NBouq += (count /k);
                count = 0;
            }
        }
        NBouq += (count / k);
        if(NBouq >= m) return true;
        return false;
    }
}