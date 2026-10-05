class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(0);
            }
            else{
                int curr = st.pop();

                if(curr == 0){
                    curr = 1;
                }else{
                    curr = 2 * curr;
                }
                st.push(st.pop() + curr);
            }
        }
        return st.peek();
    }
}