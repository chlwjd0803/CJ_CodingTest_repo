import java.util.*;


class Solution {
    
    int[] colPos;
    
    private boolean validPosition(int row, int col){
        
        // 하나라도 성립하지 못한다면(다른 퀸에 의해 방해받는다면) 그 칸은 불가능
        for(int prvRow=0; prvRow<row; prvRow++){
            if(colPos[prvRow]==col || colPos[prvRow] + (row - prvRow) == col
              || colPos[prvRow] - (row - prvRow) == col)
                return false;
        }
        
        // 위 조건을 모두 통과
        return true;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        colPos = new int[n];
        for(int i=0; i<n; i++) colPos[i] = 0;
        
        int row = 0;
        while(row>=0){
            boolean find = false;
            
            for(int col=colPos[row]; col<n; col++){
                if(validPosition(row, col)){
                    colPos[row] = col;
                    if(row==n-1){
                        answer++;
                    } else{
                        row++;
                        find=true;
                    } 
                    
                    break;
                }
            }
            if(!find){
                colPos[row--] = 0;
                if(row>=0) colPos[row]++;
            } 
        }
        
        return answer;
    }
}