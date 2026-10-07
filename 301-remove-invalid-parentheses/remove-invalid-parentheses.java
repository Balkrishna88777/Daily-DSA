class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String str = q.poll();

                if (isValid(str)) {
                    ans.add(str);
                    found = true;
                }

                if (found) {
                    continue;
                }

                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);

                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return ans;
    }
    private boolean isValid(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}