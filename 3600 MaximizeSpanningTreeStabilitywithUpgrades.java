class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if (xp == yp)
            return false;

        if (rank[xp] > rank[yp]) {
            parent[yp] = xp;
        } else if (rank[xp] < rank[yp]) {
            parent[xp] = yp;
        } else {
            parent[xp] = yp;
            rank[yp]++;
        }

        return true;
    }
}

class Solution {

    private boolean check(int n, int[][] edges, int k, int mid) {

        DSU dsu = new DSU(n);
        List<int[]> upgradeCandidates = new ArrayList<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid)
                    return false;

                dsu.union(u, v);
            }
            else {

                if (s >= mid) {
                    dsu.union(u, v);
                }

                else if (2 * s >= mid) {
                    upgradeCandidates.add(new int[]{u, v});
                }
            }
        }

        for (int[] edge : upgradeCandidates) {

            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) != dsu.find(v)) {

                if (k <= 0)
                    return false;

                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);

        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root)
                return false;
        }

        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int m = edge[3];

            if (m == 1) {

                if (dsu.find(u) == dsu.find(v))
                    return -1;

                dsu.union(u, v);
            }
        }

        int result = -1;
        int left = 1;
        int right = (int)2e5;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(n, edges, k, mid)) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }
}
