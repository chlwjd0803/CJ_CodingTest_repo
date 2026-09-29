import java.util.*;

class Solution {
    
    // 저장되는 값은 [단어인덱스, 단계수]
    private Queue<int[]> q = new LinkedList<>();
    private boolean[] visited;
    
    private int diffCount(String cur, String tar){
        int diff = 0;
        for(int i=0; i<cur.length(); i++){
            if(cur.charAt(i) != tar.charAt(i))
                diff++;
        }
        return diff;
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        // 시작 단어와 0단계 입력
        q.offer(new int[] {-1, 0});
        
        while(!q.isEmpty()){
            
            int[] temp = q.poll();
            String word = (temp[0] >= 0) ? words[temp[0]] : begin; // 시작 단어는 인덱스가 -1로 초기화되므로
            int step = temp[1];
            
            // 만약 hit했다면 그 횟수 반환
            if(diffCount(word, target) == 0)
                return step;
            
            // 그 다음 이동단계 탐색
            for(int i=0; i<words.length; i++){
                if(!visited[i] && (diffCount(word, words[i]) == 1)){
                    q.offer(new int[]{i, step+1});
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
}