class Solution {
    public int xorOperation(int n, int start) {
        int i = start;
        int ans = 0;
        while(n > 0){
            ans ^= i;
            i = i + 2;
            n--;
        }
        return ans;
    }
}