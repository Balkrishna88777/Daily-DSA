class Solution {
    public int maxProduct(int n) {
        int first = 0;
        int second = 0;

        while(n > 0){
            int temp = n % 10;

            if(temp > first){
                second = first;
                first = temp;
            }else if(first >= temp && temp > second){
                second = temp;
            }
            n /= 10;
        }
        return first * second;
    }
}