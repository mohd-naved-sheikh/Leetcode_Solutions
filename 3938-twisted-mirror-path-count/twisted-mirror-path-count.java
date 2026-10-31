class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        
        long[][] ways = new long[m][n];
        ways[0][0] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (ways[r][c] == 0) continue;
                if (r == m - 1 && c == n - 1) continue;
                
                int[] nextRight = simulate(r, c, 0, m, n, grid);
                if (nextRight[0] != -1) {
                    int nr = nextRight[0];
                    int nc = nextRight[1];
                    ways[nr][nc] = (ways[nr][nc] + ways[r][c]) % MOD;
                }
                
                int[] nextDown = simulate(r, c, 1, m, n, grid);
                if (nextDown[0] != -1) {
                    int nr = nextDown[0];
                    int nc = nextDown[1];
                    ways[nr][nc] = (ways[nr][nc] + ways[r][c]) % MOD;
                }
            }
        }
        
        return (int) ways[m - 1][n - 1];
    }
    
    private int[] simulate(int r, int c, int dir, int m, int n, int[][] grid) {
        int curr_r = r;
        int curr_c = c;
        
        while (true) {
            if (dir == 0) {
                curr_c++;
            } else {
                curr_r++;
            }
            
            if (curr_r < 0 || curr_r >= m || curr_c < 0 || curr_c >= n) {
                return new int[]{-1, -1};
            }
            
            if (curr_r == m - 1 && curr_c == n - 1) {
                return new int[]{curr_r, curr_c};
            }
            
            if (grid[curr_r][curr_c] == 0) {
                return new int[]{curr_r, curr_c};
            } else {
                if (dir == 0) {
                    dir = 1;
                } else {
                    dir = 0;
                }
            }
        }
    }
}