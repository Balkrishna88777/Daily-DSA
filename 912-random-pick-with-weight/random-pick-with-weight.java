class Solution {
    int[] arr;
    int sum = 0;
    public Solution(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];
        for(int i=1; i<w.length; i++){
            arr[i] = arr[i-1]+w[i];
        }
        sum = arr[w.length - 1];

    }
    
    public int pickIndex() {
        int low = 0;
        int high = arr.length - 1;

        int random = (int)(Math.random() * sum) + 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] >= random){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */