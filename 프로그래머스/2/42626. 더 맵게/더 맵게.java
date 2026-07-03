import java.util.*;

class Solution {
    
    private Queue<Integer> scovQueue;
    
    public int solution(int[] scoville, int K) {
        
        scovQueue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++)
            scovQueue.offer(scoville[i]);
        
        int answer = 0;
        
        while(scovQueue.size() > 1 && scovQueue.peek() < K){
            int temp = scovQueue.poll();
            scovQueue.offer(temp + scovQueue.poll() * 2);
            answer++;
        }
        
        // 마지막 요소가 K이상인지 루프가 끝나고 검증해야함
        if(scovQueue.peek() < K)
            return -1;
        
        return answer;
    }
}