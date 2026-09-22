import java.util.*;

class Solution {
    
    private int[] connection;
    
    private int findParent(int node){
        while(node != connection[node]){
            node = connection[node];
        }
        return node;
    }
    
    public int solution(int n, int[][] computers) {
        
        connection = new int[n];
        
        // 각각 부모 노드 설정
        for(int i=0; i<n; i++){
            connection[i] = i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                
                // 네트워크 연결, 부모 같게 설정
                if(computers[i][j] == 1){
                    if(findParent(i) != findParent(j))
                        connection[findParent(j)] = findParent(i);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int c : connection){
            set.add(findParent(c));
        }
        
        return set.size();
    }
}