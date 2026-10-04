class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            int profit = prices[i] - minBuy;
            maxProfit = maxProfit < profit ? profit : maxProfit;
            minBuy = minBuy < prices[i] ? minBuy : prices[i];
        }
        return maxProfit;
    }
}
