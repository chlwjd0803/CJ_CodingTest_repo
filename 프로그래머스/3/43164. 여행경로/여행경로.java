import java.util.*;

class Solution {
    
    private List<String> answer = new ArrayList<>();
    private boolean[] used;
    private int useCount = 0;
    
    private void travle(String src, String[][] tickets){
    
        for(int i=0; i<tickets.length; i++){
            
            if(!used[i] && (tickets[i][0].equals(src))){
                used[i] = true;
                useCount++;
                answer.add(tickets[i][1]);
                
                travle(tickets[i][1], tickets);
                
                if(useCount == tickets.length)
                    return;
                
                answer.remove(answer.size()-1);
                useCount--;
                used[i] = false;
            }
        }    
        
    }
    
    public String[] solution(String[][] tickets) {
        
        used = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        answer.add("ICN");
        travle("ICN", tickets);
        
        return answer.toArray(new String[0]);
    }
}