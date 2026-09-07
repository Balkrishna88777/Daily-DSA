class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int low = max;
        int high = sum;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int reqTime = daysReq(weights, mid);
            if(reqTime <= days){
                ans = mid;
                high = mid - 1;
            } 
            else if(reqTime > days){
                low = mid + 1;
            }
        }
        return ans;
    }

    public int daysReq(int[] weight, int cap){
        int day = 1;
        int load = 0;

        for(int i=0; i<weight.length; i++){
            if(load + weight[i] > cap){
                day = day + 1;
                load = weight[i];
            }else{
                load += weight[i];
            }
        }
        return day;
    }
}