class Solution {
    List<Integer>[] graph;
    boolean[] vis;
    int nodes;
    int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nodes = 0;
                degreeSum = 0;

                dfs(i);

                int edgeCount = degreeSum / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int u) {
        vis[u] = true;
        nodes++;
        degreeSum += graph[u].size();

        for (int v : graph[u]) {
            if (!vis[v]) {
                dfs(v);
            }
        }
    }
}