import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        ArrayList<String> strs = new ArrayList<>();
        
        // 문자열로 모두 변환
        for(int i=0; i<numbers.length; i++)
            strs.add(String.valueOf(numbers[i]));
        
        // 문자열 정렬
        strs.sort((a,b) -> (b+a).compareTo(a+b));
        
        // 예외처리 : 맨앞자리에 0이 있을경우 나머지 수도 0일것
        if(strs.get(0).equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<strs.size(); i++)
            sb.append(strs.get(i));
        
        return sb.toString();
    }
}