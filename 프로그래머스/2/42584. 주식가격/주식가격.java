import java.util.*;

class Solution {
    
    public int[] solution(int[] prices) {
        
        List<Integer> result = new ArrayList<>();
        int cnt;
        
        for(int i=0; i<prices.length; i++){
            
            cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt++;
                if(prices[i] > prices[j])
                    break;
            }
            
            result.add(cnt);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}