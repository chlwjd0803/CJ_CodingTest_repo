import java.util.*;

class Solution {
    
    ArrayList<Character> dict;
    int cnt;
    StringBuilder sb;
    boolean isEnd;
    
    public Solution(){
        dict = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        cnt = 1;
        isEnd = false;
        sb = new StringBuilder();
    }
    
    private void rec(String word){
        for(char alph : dict){
            sb.append(alph); // 글자 추가
            
            // 조건이 통과되면 끝내기
            if(sb.toString().equals(word) || isEnd){
                isEnd = true;
                break;
            }
            
            cnt++; // 카운트 증가
            
            // 5글자가 다 차지 않으면 재귀함수 진입
            if(sb.toString().trim().length() != 5){
                rec(word);
            }
            
            // 마지막 글자 지우기
            sb.setLength(sb.length()-1);
        }
    }
    
    public int solution(String word) {
        rec(word);
        return cnt;
    }
}