public class Solution {
    public int getMoneyAmount(int n) {
        //dp[i][j] mean the min money for guess from i to j
        int dp[][] = new int[n+1][n+1];
        for(int j = 2; j <=n; j++){
            for(int i = j-1; i >= 1; i--){
                int thisMin = Integer.MAX_VALUE;
                //k this the number we are going to pick, note the start point and end point we should pick.
                for(int k = i+1; k < j; k++){
                    //find the worst case for this pick
                    int localMax = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    //but overal we want to make the worst case not that worse
                    thisMin = Math.min(thisMin, localMax);
                }
                //note the edge case here
                dp[i][j] = i+1 == j? i:thisMin;
            }
        }
        return dp[1][n];
    }
}