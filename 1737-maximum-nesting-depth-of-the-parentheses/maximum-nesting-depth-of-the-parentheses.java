class Solution {
    public int maxDepth(String s) {
        int maxCounter = 0;
        int counter = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                counter++;
                maxCounter = Math.max(maxCounter, counter);
            }

            if(s.charAt(i) == ')'){
                counter--;
                maxCounter = Math.max(maxCounter, counter);
            }
        }
        return maxCounter;
    }
}