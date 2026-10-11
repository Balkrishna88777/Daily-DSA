class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int f) {
        int empty = 0;
        int n = flowerbed.length;

        if (n == 1) {
            if (flowerbed[0] == 0) {
                empty++;
            }
            return empty >= f;
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            empty++;
            flowerbed[0] = 1;
        }

        if(flowerbed[n-1] == 0 && flowerbed[n-2] == 0){
            empty++;
            flowerbed[n-1] = 1;
        }

        for(int i=1; i<n-1; i++){
            if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                empty++;
                flowerbed[i] = 1;
            }
        }

        if(empty >= f) return true;
        return false;
    }
}