import java.util.*;
import java.io.*;

class Solution {
    
    private Map<String, Integer> map;
    
    public Solution(){
        map = new HashMap<>();
    }
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. 완주자를 맵에 집어넣기
        for(String s : completion){
            // 동명이인이 있다면 사람 수만 증가
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } 
            // 동명이인이 아닌 새로 추가되는 사람이라면
            else {
                map.put(s, 1);
            }
        }
        
        // 2. 전체 참가자에서 완주자 제거하며 검색
        for(String s : participant){
            
            // 참가자 명단에 있다면
            if(map.containsKey(s)){
                // 동명이인이 있다면 수만 감소
                if(map.get(s) > 1){
                    map.put(s, map.get(s) - 1);
                } else {
                    // 없으면 제거
                    map.remove(s);
                }
            } else {
                // 없다면 완주하지 못한 선수 한명 발견한 것
                answer = s;
                break;
            }
        }
        
        return answer;
    }
}