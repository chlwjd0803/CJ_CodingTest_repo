import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> temp = new ArrayList<>();
        
        int cnt;
        int index = 0;
        
        while(index < progresses.length){
            
            cnt = 0;
            
            for(int i=index; i<progresses.length; i++)
                progresses[i] += speeds[i];
            
            while(progresses[index] >= 100){
                cnt++;
                index++;
                if(index == progresses.length)
                    break;
            }
            
            if(cnt > 0)
                temp.add(cnt);
        }
        
        int[] answer = new int[temp.size()];
        
        for(int i=0; i<temp.size(); i++)
            answer[i] = temp.get(i);
        
        return answer;
    }
}