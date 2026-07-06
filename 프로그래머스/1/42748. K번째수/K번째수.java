import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // 결과를 저장할 리스트
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int[] command : commands){
            
            // 구간 슬라이싱 하기
            int[] sliced = Arrays.copyOfRange(array, command[0]-1, command[1]);
            
            Arrays.sort(sliced);
            
            result.add(sliced[command[2]-1]);
        }
        
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);
        return answer;
    }
}