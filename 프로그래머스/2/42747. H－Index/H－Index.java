import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        ArrayList<Integer> cits = new ArrayList<>();
        
        for(int i=0; i<citations.length; i++)
            cits.add(citations[i]);
        
        cits.sort((a,b) -> b.compareTo(a));
        
        int h;
        for(h=0; h<cits.size() && (h+1 <= cits.get(h)); h++);
        
        return h;
    }
}