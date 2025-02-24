class Solution {
    
    public static int square(int a, int b, int c){
        var min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        return min + 1;
    }
    
    
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int max = 0; //돗자리 최대 길이
        
        int[][] dp = new int[park.length][park[0].length];
        
        // 가장자리 부분은 미리 값을 처리
        for (int i = 0; i < park.length; i++)
            if (park[i][0].equals("-1")) dp[i][0] = 1;
        for (int j = 0; j < park[0].length; j++)
            if (park[0][j].equals("-1")) dp[0][j] = 1;

        
        
        for(int i=1; i<park.length; i++) for(int j=1; j<park[0].length; j++){
            if(park[i][j].equals("-1")){
                dp[i][j] = square(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
                if(max < dp[i][j]) max = dp[i][j];
            } else {
                dp[i][j] = 0;
            }
            
        }
        
        for(int i=0; i<mats.length; i++){
            if(mats[i] <= max && mats[i] > answer) answer = mats[i];
        }
            
        
        return answer;
    }
}