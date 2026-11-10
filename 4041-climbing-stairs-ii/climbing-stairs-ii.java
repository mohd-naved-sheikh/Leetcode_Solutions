class Solution {
    public int climbStairs(int n, int[] costs) {
        final long INF = Long.MAX_VALUE/4;
        long p3 = INF;
        long p2 = INF;
        long p1 =0;

        for(int i=1;i<=n;i++){
            long best = Math.min(p1+1,
            Math.min(p2+4,p3+9));
            long cur = best+costs[i-1];
            p3 = p2;
            p2 =p1;
            p1 = cur;
        }
        return (int) p1;
    }
}