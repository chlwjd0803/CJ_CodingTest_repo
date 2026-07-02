import java.util.*;

class Solution {
    
    private Deque<Integer> bridge;
    private Deque<Integer> wait;
    private Deque<Integer> complete;
    
    public Solution(){
        bridge = new ArrayDeque<>();
        wait = new ArrayDeque<>();
        complete = new ArrayDeque<>();
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 1. 다리 Deque 빈공간 0으로 패딩
        for(int i=0; i<bridge_length; i++)
            bridge.offerLast(0);
        
        // 2. 트럭 Deque 대기트럭 삽입
        for(int i=0; i<truck_weights.length; i++)
            wait.offerLast(truck_weights[i]);
        
        // 현재 다리에 가중된 무게
        int curWeight = 0;
        // 시간
        int time = 0;
        // 큐 추출용 임시변수
        int temp;
        // 3. 대기열이 모두 빠지고, 모두 도착하기 전까지 실행
        while(!wait.isEmpty() || complete.size() != truck_weights.length){
            
            // 다리에 있던거 먼저 내리기
            temp = bridge.pollFirst();
            // 패딩값이 아닌 트럭이라면 완료 큐에 삽입
            if(temp != 0){
                complete.offerLast(temp);
                // 현재 무게 감소
                curWeight -= temp;
            }
            
            if(wait.size()>0){
                // 다리에 올리는 작업
                temp = wait.peekFirst();
                // 올려도 되는 상황이라면
                if(curWeight+temp <= weight){
                    // 다리에 올리기
                    bridge.offerLast(wait.pollFirst());
                    // 현재 무게 증가
                    curWeight += temp;
                } else {
                    // 안되면 다시 0으로 패딩
                    bridge.offerLast(0);
                }    
            } else {
                bridge.offerLast(0);
            }
            
            time++;
        }
        return time;
    }
}