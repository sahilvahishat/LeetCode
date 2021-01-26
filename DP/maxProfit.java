package DP;

public class maxProfit {
    public int maxProfitData(int[] prices) {
        if (prices.length == 0)
            return 0;
        int maxProfit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int sellPrice = prices[i];
            if (sellPrice > buyPrice) {
                maxProfit = Math.max(sellPrice - buyPrice, maxProfit);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}