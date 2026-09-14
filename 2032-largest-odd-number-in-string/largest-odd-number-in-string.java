class Solution {
    public String largestOddNumber(String num) {
        char last = num.charAt(num.length() - 1);
        int index = -1;

        if(last == '1' || last == '3' || last == '5' ||last == '7' || last == '9') return num;

        for(int i = num.length()-1; i>=0; i--){
            if(num.charAt(i) % 2 == 1){
                index = i;
                break;
            }
        }
       return num.substring(0, index+1);
    }
}