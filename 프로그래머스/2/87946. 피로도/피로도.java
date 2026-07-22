class Solution {
    
    int max;
    boolean[] visited;
    
    private void search(int[][] dg, int curK, int cnt){
        max = Math.max(max,cnt);
        
        for(int i=0; i<dg.length; i++){
            if(visited[i]) continue;
            
            if(curK >= dg[i][0]){
                visited[i] = true;
                search(dg, curK - dg[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
        
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[k];
        max = 0;
        
        search(dungeons, k, 0);
        
        return max;
    }
}