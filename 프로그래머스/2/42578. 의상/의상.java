import java.util.*;

class Solution {
    
    private Map<String, Integer> map;
    
    public Solution(){
        map = new HashMap<>();
    }
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for(int i=0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            } else {
                map.put(clothes[i][1], 2);
            }
        }
        
        for(Map.Entry<String, Integer> e : map.entrySet()){
            answer *= e.getValue();
        }
        
        return answer-1;
    }
}