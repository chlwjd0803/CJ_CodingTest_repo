class Solution {
    
    private int[] dp;
    
    private int theif(int[] money, int start, int end){
        dp = new int[money.length];
        
        for(int i=start; i<=end; i++){
            if(i==start){
                dp[i] = money[i];
            } else if(i==start+1) {
                dp[i] = Math.max(dp[i-1], money[i]);
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
            }
        }
        
        return dp[end];
    }

    public int solution(int[] money) {
        int n = money.length;
        
        return Math.max(theif(money, 0, n - 2), theif(money, 1, n - 1));
    }
}