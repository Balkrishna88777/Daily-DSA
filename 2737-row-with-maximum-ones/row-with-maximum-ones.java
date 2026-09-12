class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int index = -1;
        int maxCnt = -1;

        for(int i=0; i<n; i++){
            int cntRow = 0;
            for(int j=0; j<m; j++){
                cntRow += mat[i][j];
            }
            if(cntRow > maxCnt){
                maxCnt = cntRow;
                index = i;
            }
        }
        return new int[]{index, maxCnt};
    }
}