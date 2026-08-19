class Solution {
    public long solution(int m, int n, int[][] puddles) {
        
        long[][] region = new long[m+1][n+1];
        boolean[][] isPuddles = new boolean[m+1][n+1];
        
        for(int[] puddle : puddles)
            isPuddles[puddle[0]][puddle[1]] = true;
           
        region[1][1] = 1;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(isPuddles[i][j])
                    continue;
                if(!isPuddles[i-1][j])
                    region[i][j] += region[i-1][j]%1000000007;
                if(!isPuddles[i][j-1])
                    region[i][j] += region[i][j-1]%1000000007;
            }
        }
        
        return region[m][n]%1000000007;
    }
}