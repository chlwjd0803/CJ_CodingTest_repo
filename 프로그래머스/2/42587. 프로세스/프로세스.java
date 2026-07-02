import java.util.*;

class Solution {
    
    // Key : 우선순위 수준 / Value : 개수
    private Map<Integer, Integer> idxPri;
    // [0] : 인덱스 / [1] : 우선순위 수준
    private Deque<int[]> queue;
    
    public Solution(){
        // 우선순위 수준이 내림차순으로 정렬되어야함
        idxPri = new TreeMap<>(Collections.reverseOrder());
        queue = new ArrayDeque<>();
    }
    
    public int solution(int[] priorities, int location) {
        
        for(int i=0; i<priorities.length; i++){
            
            // 우선순위 트리맵 채우기
            if(idxPri.containsKey(priorities[i])){
                idxPri.put(priorities[i], idxPri.get(priorities[i]) + 1);
            } else {
                idxPri.put(priorities[i], 1);
            }
            
            // 데크에 프로세스 큐 할당
            queue.offerLast(new int[]{i, priorities[i]});
        }
        
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : idxPri.entrySet()){
            
            while(entry.getValue() > 0){
                
                int[] temp = queue.pollFirst();
                
                // 만약 큐에서 가장 앞 원소가 해당 우선순위가 아니면 재삽입
                if(temp[1] != entry.getKey()){
                    queue.offerLast(temp);
                } else {
                    // 같은 우선순위라면 재삽입하지않고 실행완료 카운트 올리기
                    cnt++;
                    // 프로세스를 하나 찾았으므로 하나 감소
                    entry.setValue(entry.getValue()-1);
                    // 검색하려는 위치가 맞는 경우 차례 반환
                    if(location == temp[0])
                        return cnt;
                }
            }
        }
        return cnt;
    }
}