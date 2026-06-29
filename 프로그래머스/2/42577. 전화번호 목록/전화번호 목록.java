import java.util.*;

class Solution {
    
    private Map<String, Integer> map;
    
    public Solution(){
        map = new HashMap<>();
    }
    
    public boolean solution(String[] pb) {
        
        for(String p : pb){
            map.put(p, 1);
        }
        
        for(String p : pb){
            
            for(int i=1; i<p.length(); i++){
                if(map.containsKey(p.substring(0,i))){
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
}