import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int[] dp = new int[sticker.length];
        int answer = -1;
        
        // 하나만 뜯으면 될때
        if(sticker.length == 1)
            return sticker[0];
        if(sticker.length == 2)
            return Math.max(sticker[0], sticker[1]);
        
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);
        
        for(int i=2; i<sticker.length-1; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        answer = Math.max(dp[sticker.length-2], answer);
        
        dp[1] = sticker[1];
        dp[2] = Math.max(sticker[1], sticker[2]);
        
        for(int i=3; i<sticker.length; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        answer = Math.max(dp[sticker.length-1], answer);
        
        return answer;
    }
}