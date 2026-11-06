class Solution {
    public int[] countServers(int n, int[][] logs,int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = queries.length;

        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
            (a, b) -> a[0] - b[0]);

        int[] ans = new int[m];

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];
            int index = query[1];

            while (right < logs.length &&
                   logs[right][1] <= q) {

                int server = logs[right][0];

                map.put(server,
                    map.getOrDefault(server, 0) + 1);

                if (map.get(server) == 1) {
                    activeServers++;
                }

                right++;
            }

            while (left < right &&
                   logs[left][1] < q - x) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                    activeServers--;
                }

                left++;
            }

            ans[index] = n - activeServers;
        }

        return ans;
    }
}
