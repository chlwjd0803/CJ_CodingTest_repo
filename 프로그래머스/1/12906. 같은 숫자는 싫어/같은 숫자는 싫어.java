import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // 1. 원소를 담을 임시 리스트 할당
        List<Integer> temp = new ArrayList<>();
        
        // 2. 직전 변수를 담기 위한 할당 (조건에 의해서 0~9 사이의 정수가 아닌 수로 초기화)
        int prv = -1;
        
        // 3. 순회 시작
        for(int i=0; i<arr.length; i++){
            // 중복되는게 온다면 건너뛰기
            if(prv == arr[i]) 
                continue;
            
            // 임시 리스트에 저장하고 이전 변수로 저장
            temp.add(arr[i]);
            prv = arr[i];
        }

        int[] answer = new int[temp.size()];
        
        for(int i=0; i<temp.size(); i++)
            answer[i] = temp.get(i);
        
        return answer;
    }
}