class Solution {
    public int maxProfit(int[] prices) {
        int max_profit=0;
        int min_f=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min_f)min_f=prices[i];
            else{
                max_profit=Math.max(max_profit,prices[i]-min_f);
            }
        }
        return max_profit;
    }
}
