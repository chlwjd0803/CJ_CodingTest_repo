import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] having = new int[n];
        Arrays.fill(having, 1);
        
        int impossible = 0;
        
        for(int lIndex : lost){
            having[lIndex-1]--;
        }
        
        for(int rIndex : reserve){
            having[rIndex-1]++;
        }
        
        for(int i=0; i<n; i++){
            if(having[i]==0){   
                if(i!=0 && having[i-1] >= 2){
                    having[i-1]--;
                    having[i]++;
                } else if(i!=n-1 && having[i+1] >= 2){
                    having[i+1]--;
                    having[i]++;
                } else {
                    impossible++;
                }
            }
        }
        
        return n-impossible;
    }
}