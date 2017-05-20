public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int days = prices.length;
        int[] buy = new int[days+1];
        int[] sell = new int[days+1];
        
        //status at day 1(index = 0)
        int b0 = -prices[0];
        int s2 = 0;
        int s1 = 0;
        int b1 = b0;
        int s0 = 0;
        /*
        see the corresponding relationship
        buy[i] = Math.max(sell[i-2] - cur, buy[i-1]);
        sell[i] = Math.max(buy[i-1] + cur, sell[i-1]);
        */
        for(int i = 1; i < days; i++){
            int cur = prices[i];
            b0 = Math.max(s2 - cur, b1);
            s0 = Math.max(b1 + cur, s1);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}