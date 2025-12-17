class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n < 2 || k == 0) return 0;

        long[][] dp = new long[k+1][n];

    
        for (int t = 1; t <= k; t++) {
            long best_buy = -prices[0];  
            long best_short = prices[0];  

            dp[t][0] = 0; 

            for (int i = 1; i < n; i++) {

                long noNew = dp[t][i-1];

                long closeLong = best_buy + prices[i];

                long closeShort = best_short - prices[i];

                long val = Math.max(noNew, Math.max(closeLong, closeShort));
                dp[t][i] = val;
                long prevDp = dp[t-1][i-1]; 
                long candidateBuy = prevDp - prices[i];
                if (candidateBuy > best_buy) best_buy = candidateBuy;

                long candidateShort = prevDp + prices[i];
                if (candidateShort > best_short) best_short = candidateShort;
            }
        }

        return dp[k][n-1];
    }
}