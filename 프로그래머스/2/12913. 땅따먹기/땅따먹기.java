class Solution {
    int solution(int[][] land) {
        int row = land.length;
        int col = 4;
        int max = -1;
        
        int[][] dp = new int[row][col];
        
        for(int i=0; i<row; i++) for(int j=0; j<col; j++){
            dp[i][j] = land[i][j];
        }
        
        // for(int i=0; i<col; i++){
        //     if(max<dp[0][i]) max = dp[0][i];
        // }
        
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<col; k++){
                    if(j==k) continue;
                    
                    dp[i][j] = Math.max(dp[i-1][k]+land[i][j], dp[i][j]);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        
        return max;
    }
}