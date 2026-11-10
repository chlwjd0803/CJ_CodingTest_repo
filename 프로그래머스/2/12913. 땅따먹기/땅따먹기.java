class Solution {
    int solution(int[][] land) {
        int row = land.length;
        int col = 4;
        
        int[][] dp = new int[row][col];
        
        for(int i=0; i<row; i++) for(int j=0; j<col; j++){
            dp[i][j] = land[i][j];
        }
        
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<col; k++){
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i-1][k]+land[i][j], dp[i][j]);
                }
            }
        }
        
        // 마지막 행에서 최댓값
        int max = 0;
        for (int j = 0; j < col; j++) {
            max = Math.max(max, dp[row - 1][j]);
        }
        return max;
    }
}