import java.util.*;

class Solution {
    
    // 0:x좌표, 1:y좌표, 2:이동칸수
    private Queue<int[]> q = new LinkedList<>();
    private int[][] position = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean[][] visited;
    
    // 좌표 범위 안인지
    private boolean isInScope(int x, int y){
        return !((x<1) || (x>100) || (y<1) || (y>100));
    }
    
    // 하나의 도형 선분 위에만 올라가 있으면 됨
    private boolean anyInOnTheLine(int x, int y, int[][] rectangle){
        
        for(int[] rec : rectangle){
            if(((((x==rec[0]) || (x==rec[2])) && ((y>=rec[1]) && (y<=rec[3]))) 
            || (((y==rec[1]) || (y==rec[3])) && ((x>=rec[0]) && (x<=rec[2])))))
                return true;
        }
        return false;
    }
    
    // 어떤 도형의 내부에도 들어가면 안됨
    private boolean allIsNotInside(int x, int y, int[][] rectangle){
        
        for(int[] rec : rectangle){
            if((x>rec[0]) && (x<rec[2]) && (y>rec[1]) && (y<rec[3]))
                return false;
        }
        return true;
    }
    
    // 1칸에서 선분이 아닌 부분을 통과하지 못하는 문제를 해결해야함
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 2배 취급하여 1칸 범위의 예외를 해결
        visited = new boolean[101][101];
        
        // 스케일 업
        int[][] rect = new int[rectangle.length][4];
        for(int i=0; i<rectangle.length; i++){
            for(int j=0; j<4; j++){
                rect[i][j] = rectangle[i][j] * 2;
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        q.offer(new int[] {characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int chX = temp[0];
            int chY = temp[1];
            int step = temp[2];
            
            if(chX == itemX && chY == itemY)
                return step / 2; // 실제 스텝 수는 스케일 다운   
            
            for(int[] pos : position){
                if(
                    isInScope(chX+pos[0], chY+pos[1])
                    && !visited[chX+pos[0]][chY+pos[1]]
                    && anyInOnTheLine(chX+pos[0], chY+pos[1], rect)
                    && allIsNotInside(chX+pos[0], chY+pos[1], rect)
                ){
                    q.offer(new int[] {chX+pos[0], chY+pos[1], step+1});
                    visited[chX+pos[0]][chY+pos[1]] = true;
                }
            }
            
        }
        
        return -1;
    }
}