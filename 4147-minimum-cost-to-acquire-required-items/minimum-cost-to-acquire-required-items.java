
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long common = Math.min(need1, need2);

        long remaining1 = need1 - common;
        long remaining2 = need2 - common;

        long bothCost = common * Math.min(costBoth, cost1 + cost2);

        long extra1 = remaining1 * Math.min(cost1, costBoth);
        long extra2 = remaining2 * Math.min(cost2, costBoth);

        return bothCost + extra1 + extra2;
    }
}
