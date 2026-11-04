import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        
        Comparator<int[]> comp = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };
        
        TreeSet<int[]> left = new TreeSet<>(comp);
        TreeSet<int[]> right = new TreeSet<>(comp);
        
        long[] leftSum = new long[1];
        long[] rightSum = new long[1];
        
        Runnable balance = () -> {
            int targetLeft = (x + 1) / 2;
            while (left.size() > targetLeft) {
                int[] p = left.last();
                left.remove(p);
                leftSum[0] -= p[0];
                right.add(p);
                rightSum[0] += p[0];
            }
            while (left.size() < targetLeft && !right.isEmpty()) {
                int[] p = right.first();
                right.remove(p);
                rightSum[0] -= p[0];
                left.add(p);
                leftSum[0] += p[0];
            }
        };
        
        for (int i = 0; i < n; i++) {
            int[] addElem = new int[]{nums[i], i};
            if (left.isEmpty() || addElem[0] <= left.last()[0]) {
                left.add(addElem);
                leftSum[0] += addElem[0];
            } else {
                right.add(addElem);
                rightSum[0] += addElem[0];
            }
            balance.run();
            
            if (i >= x) {
                int removeIdx = i - x;
                int removeVal = nums[removeIdx];
                int[] remElem = new int[]{removeVal, removeIdx};
                if (left.contains(remElem)) {
                    left.remove(remElem);
                    leftSum[0] -= removeVal;
                } else {
                    right.remove(remElem);
                    rightSum[0] -= removeVal;
                }
                balance.run();
            }
            
            if (i >= x - 1) {
                long median = left.last()[0];
                long currentCost = (left.size() * median - leftSum[0]) + (rightSum[0] - right.size() * median);
                cost[i - x + 1] = currentCost;
            }
        }
        
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 1; j <= k; j++) {
            long minSoFar = Long.MAX_VALUE / 2;
            for (int i = n - x; i >= 0; i--) {
                long take = cost[i] + dp[Math.min(n, i + x)][j - 1];
                minSoFar = Math.min(minSoFar, take);
                dp[i][j] = minSoFar;
            }
        }
        
        return dp[0][k];
    }
}