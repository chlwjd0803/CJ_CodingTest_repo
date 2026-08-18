import java.util.*;

class Solution {
    
    private int[] parent;
    
    private int find(int x){
        while(parent[x] != x){
            x = parent[x];
        }
        // 대표 반환
        return x;
    }
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        parent = new int[n];
        
        // 대표 설정
        for(int i=0; i<n; i++)
            parent[i] = i;
        
        int answer = 0;
        for(int[] cost : costs){
            if(find(cost[0]) != find(cost[1])){
                parent[find(cost[1])] = parent[find(cost[0])];
                answer += cost[2];
            }
        }
        
        return answer;
    }
}