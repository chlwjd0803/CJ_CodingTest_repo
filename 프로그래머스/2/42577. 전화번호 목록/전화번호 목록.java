import java.util.*;

class Solution {
    
    private Set<String> set;
    
    public Solution(){
        set = new HashSet<>();
    }
    
    public boolean solution(String[] pb) {
        
        for(String p : pb){
            set.add(p);
        }
        
        for(String p : pb){
            for(int i=1; i<p.length(); i++){
                if(set.contains(p.substring(0,i))){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}
