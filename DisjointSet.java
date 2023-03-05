    private void union(int u, int v) {
        u = par[u];
        v = par[v];
        if (rank[u] > rank[v])
            par[v] = u;
        else if (rank[u] < rank[v])
            par[u] = v;
        else {
            par[u] = v;
            rank[v]++;
        }
    }
    private int find(int node) {
        if (par[node] == node) return node;
        return par[node] = find(par[node]);
    }
