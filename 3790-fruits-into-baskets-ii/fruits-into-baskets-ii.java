class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = fruits.length;

        for(int l=0; l<fruits.length; l++){
            int r = 0;
            while(r < fruits.length){
                if(baskets[r] >= fruits[l]){
                    baskets[r] = -1;
                    count--;
                    break;
                }else{
                    r++;
                }
                
            }
        }
        return count;
    }
}