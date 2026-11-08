class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            int currentProfit = prices[i] - min;
            maxProfit = Math.max(maxProfit,currentProfit);
        }
        return maxProfit;
    }
}