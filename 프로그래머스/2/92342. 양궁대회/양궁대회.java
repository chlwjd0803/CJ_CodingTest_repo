import java.util.*;

class Solution {
    
    int[] apeach;
    int[] lion;
    int[] winArr = new int[]{-1};
    
    int best = 0;
    int N;
    
    // a가 b보다 "낮은 점수를 더 많이 맞혔는지" (인덱스 10부터 거꾸로 비교)
    // 뒤에서부터 탐색하다가 더 많은쪽(작은게 더 많다)이 이김
    private boolean isBetter(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return false;
    }
    
    private void comp(){
        // 둘의 점수 집계를 위한 변수
        int li = 0;
        int ap = 0;
        
        for(int i=0; i<=10; i++){
            
            if(lion[i] == 0 && apeach[i] == 0)
                continue;
            else if(lion[i]>apeach[i])
                li += 10-i;
            else // 어피치가 유리한 조건
                ap += 10-i;
        }
        
        if (li > ap) {
            int diff = li - ap;
            // 더 낮은점수로 구성되어있다면
            if (diff > best || (diff == best && isBetter(lion, winArr))) {
                winArr = lion.clone();
                best = diff;
            }
        }
    }
    
    private void rec(int index, int left){
        if(left == 0){
            comp();
            return;
        }
            
        for(int i=index; i<=10; i++){
            lion[i]++;
            rec(i, left-1);
            lion[i]--;
        }
    }
    
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        
        // 초기화
        lion = new int[11];
        
        for(int i=0; i<=10; i++)
            lion[i] = 0;
        
        // 화살을 하나도 안쓴채로 출발
        rec(0, n);
        
        return winArr;
    }
}