import java.util.*;

class Solution {
    
    char[][] maze;
    boolean[][] visited;
    
    int width;
    int height;
    int time = 0;
    
    int startRow;
    int startCol;
    
    
    int[][] direction = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    private boolean validMove(int row, int col){
        return (row>=0) && (row<height) && (col>=0) && (col<width);
    }
    
    
    private boolean find(char target, int curTime){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[height][width];
        
        // 행, 열, 시간
        q.offer(new int[] {startRow, startCol, curTime});
        visited[startRow][startCol] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(maze[temp[0]][temp[1]] == target){
                // 찾은 위치를 기록과 함께 시간도 기록
                startRow = temp[0];
                startCol = temp[1];
                time = temp[2];
                return true;
            }
            
            for(int[] d : direction){
                // 움직일 수 있다면
                if(validMove(temp[0]+d[0], temp[1]+d[1]) 
                   && !visited[temp[0]+d[0]][temp[1]+d[1]] && maze[temp[0]+d[0]][temp[1]+d[1]] != 'X'){
                    // 다음 위치를 넣기, 시간도 1초 증가
                    q.offer(new int[] {temp[0]+d[0], temp[1]+d[1], temp[2]+1});
                    // 방문처리
                    visited[temp[0]+d[0]][temp[1]+d[1]] = true;
                }
            }
        }
        return false;
        
    }
    
    
    public int solution(String[] maps) {
        
        height = maps.length;
        width = maps[0].length();
        
        maze = new char[height][width];
        
        // 배열로 초기화
        for(int i=0; i<height; i++) for(int j=0; j<width; j++){
            maze[i][j] = maps[i].charAt(j);
            if(maze[i][j] == 'S'){
                startRow = i;
                startCol = j;
            }
        }
            
        return (find('L', time) && find('E', time)) ? time : -1;
        
    }
}