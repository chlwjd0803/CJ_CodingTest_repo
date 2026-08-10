import java.util.*;

class Solution {
    
    // 그래프를 저장하는 리스트
    private List<List<Integer>> gp = new ArrayList<>();
    private boolean[] visited;
    private int min = Integer.MAX_VALUE;
    
    
    private void dfs(int node, int startSkip, int endSkip){
        visited[node] = true;
        
        for(int nextNode : gp.get(node)){
            // 스킵조건
            if((node==startSkip && nextNode==endSkip) || (node==endSkip && nextNode==startSkip))
                continue;
            // 방문하지 않은 노드로 검색 계속 : dfs 조건 (아닐시는 아무 효과 없음)
            if(!visited[nextNode]) 
                dfs(nextNode, startSkip, endSkip);
        }
    }
    
    
    public int solution(int n, int[][] wires) {
        
        // 방문 여부 저장을 위한 배열 추가
        visited = new boolean[n+1];
        
        // 각 노드들의 연결정보를 저장하기 위한 할당
        for(int i=0; i<=n; i++)
            gp.add(new ArrayList<>());
        
        // 양방향 저장
        for(int[] wire : wires){
            gp.get(wire[0]).add(wire[1]);
            gp.get(wire[1]).add(wire[0]);
        }
        
        // 끊어지는 wires 순회
        for(int[] wire : wires){
            // 이건 매번 초기화
            Arrays.fill(visited, false);
            // 시작 노드와 끊어진 wire 전달
            dfs(1, wire[0], wire[1]);
            
            // true 개수 구하기
            int count = 0;
            for(int i=1; i<=n; i++){
                if(visited[i]) count++;
            }
            
            // 둘의 차를 비교하여 더 적을시 변경
            if(min > Math.abs(count-(n-count)))
                min = Math.abs(count-(n-count));
        
        }
        return min;
    }
}