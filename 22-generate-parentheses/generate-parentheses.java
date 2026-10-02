class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String curr, int sr, int sc, int n){
        if(curr.length() == 2 * n){
            ans.add(curr);
            return;
        }

        if(sr < n){
            backtrack(ans, curr + "(", sr + 1, sc, n);
        }

        if(sc < sr){
            backtrack(ans, curr + ")", sr, sc+1, n);
        }
    }
}