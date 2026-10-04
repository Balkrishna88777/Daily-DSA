class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        char[] arr = new char[s.length()];
        arr = s.toCharArray();


        for(int i=0; i<arr.length; i++){
            char c = arr[i];

            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low--;
                high--;
            }
            else{
                low--;
                high++;
            }

            low = Math.max(0, low);

            if(high < 0){
                return false;
            }
        }
        return low == 0;
    }
}