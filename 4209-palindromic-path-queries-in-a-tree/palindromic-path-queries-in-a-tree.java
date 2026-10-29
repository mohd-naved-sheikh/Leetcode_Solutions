import java.util.*;

class Solution {
    int[] head, heavy, parent, depth, pos, treeNodeAtPos;
    int curPos;
    List<Integer>[] adj;
    int[] seg;
    int[] val;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        head = new int[n];
        heavy = new int[n];
        parent = new int[n];
        depth = new int[n];
        pos = new int[n];
        treeNodeAtPos = new int[n];
        Arrays.fill(heavy, -1);

        dfs1(0, -1, 0);
        curPos = 0;
        dfs2(0, 0);

        val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = 1 << (s.charAt(i) - 'a');
        }

        seg = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> ans = new ArrayList<>();
        for (String qStr : queries) {
            String[] parts = qStr.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                int newVal = 1 << (c - 'a');
                val[u] = newVal;
                update(1, 0, n - 1, pos[u], newVal);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int xorSum = queryPath(u, v, n);
                ans.add(Integer.bitCount(xorSum) <= 1);
            }
        }
        return ans;
    }

    private int dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1;
        int maxSub = 0;
        for (int v : adj[u]) {
            if (v != p) {
                int sub = dfs1(v, u, d + 1);
                size += sub;
                if (sub > maxSub) {
                    maxSub = sub;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = curPos;
        treeNodeAtPos[curPos++] = u;
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : adj[u]) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            seg[node] = val[treeNodeAtPos[start]];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        seg[node] = seg[2 * node] ^ seg[2 * node + 1];
    }

    private void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            seg[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (idx >= start && idx <= mid) {
            update(2 * node, start, mid, idx, value);
        } else {
            update(2 * node + 1, mid + 1, end, idx, value);
        }
        seg[node] = seg[2 * node] ^ seg[2 * node + 1];
    }

    private int querySeg(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return seg[node];
        int mid = (start + end) / 2;
        return querySeg(2 * node, start, mid, l, r) ^ querySeg(2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v, int n) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] > depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= querySeg(1, 0, n - 1, pos[head[v]], pos[v]);
            v = parent[head[v]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= querySeg(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}