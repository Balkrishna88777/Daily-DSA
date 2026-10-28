class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = k-1;

        int count = 0;

        int sum = 0;

        for(int i =left; i<k; i++){
            sum += arr[i];
        }

        if((sum / k) >= threshold) count++;

        while(right < arr.length-1){
            sum = sum - arr[left];

            left++;
            right++;

            sum = sum + arr[right];

            if((sum / k) >= threshold) count++;
        }

        return count;
    }
}