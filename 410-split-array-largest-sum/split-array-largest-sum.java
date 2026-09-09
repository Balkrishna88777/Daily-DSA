class Solution {
    public int splitArray(int[] arr, int k) {
        if(k > arr.length) return - 1;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        
        long low = max;
        long high = sum;
        
        while(low <= high){
            long mid = low + (high - low)/2;
            int cntStudent = helper(arr, mid);
            
            if(cntStudent > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int) low;
    }
    public int helper(int[] arr, long pages){
        int studentNo = 1;
        long pagesCount = 0;
        
        for(int i=0; i<arr.length; i++){
            if(pagesCount + arr[i] <= pages){
                pagesCount += arr[i];
            }else{
                pagesCount = arr[i];
                studentNo++;
            }
        }
        return studentNo;
    }
}