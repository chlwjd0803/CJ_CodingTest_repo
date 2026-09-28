import java.util.*;

class Solution {
    
    private boolean[][] visited;
    private Queue<int[]> q = new LinkedList<>();
    private int row;
    private int col;

    public int solution(int[][] maps) {
        
        row = maps.length; // 세로길이
        col = maps[0].length; // 가로길이
        
        // 방문여부
        visited = new boolean[row][col];
        
        // r 행, c 열, d 이동칸
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int d = node[2];
            
            if(r==row-1 && c==col-1)
                return d;
            
            // 오른쪽
            if((c+1 < col) && (maps[r][c+1] == 1) && !visited[r][c+1]){
                q.offer(new int[] {r, c+1, d+1});
                visited[r][c+1] = true;
            }

            // 아래쪽
            if((r+1 < row) && (maps[r+1][c] == 1) && !visited[r+1][c]){
                q.offer(new int[] {r+1, c, d+1});
                visited[r+1][c] = true;
            }

            // 왼쪽
            if((c-1 >= 0) && (maps[r][c-1] == 1) && !visited[r][c-1]){
                q.offer(new int[] {r, c-1, d+1});
                visited[r][c-1] = true;
            }

            // 위쪽
            if((r-1 >= 0) && (maps[r-1][c] == 1) && !visited[r-1][c]){
                q.offer(new int[] {r-1, c, d+1});
                visited[r-1][c] = true;
            }
        }
        
        return -1;
    }
}



//      dfs 시간초과 오답
//     private void dfs(int dep, int r, int c, int[][] maps){
//         // 목표에 도달했을 경우
//         if(r == row-1 && c == col-1){
//             min = Math.min(min, dep);
//             return;
//         }
        
//         // 방문 체크
//         visited[r][c] = true;
        
//         // 오른쪽
//         if((c+1 < col) && (maps[r][c+1] == 1) && !visited[r][c+1]){
//             dfs(dep+1, r, c+1, maps);
//         }
        
//         // 아래쪽
//         if((r+1 < row) && (maps[r+1][c] == 1) && !visited[r+1][c]){
//             dfs(dep+1, r+1, c, maps);
//         }
        
//         // 왼쪽
//         if((c-1 >= 0) && (maps[r][c-1] == 1) && !visited[r][c-1]){
//             dfs(dep+1, r, c-1, maps);
//         }
        
//         // 위쪽
//         if((r-1 >= 0) && (maps[r-1][c] == 1) && !visited[r-1][c]){
//             dfs(dep+1, r-1, c, maps);
//         }
        
//         // 돌아가기 전 방문해제
//         visited[r][c] = false;
//     }
    