class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')' && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        return st.size();
    }
}

// int count = 0;

//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) == '('){
//                 count++;
//             }else if(count == 0 && s.charAt(i) == ')'){
//                 count++;
//             }else{
//                 count--;
//             }
//         }
//         return Math.abs(count);