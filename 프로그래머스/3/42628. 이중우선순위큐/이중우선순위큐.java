import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        // 트리셋의 고유 메소드를 사용하기 위해 업캐스팅 금지
        TreeSet<Integer> dpq = new TreeSet<>();
        
        for(String s : operations){
            StringTokenizer st = new StringTokenizer(s);
            
            String instruction = st.nextToken();
            Integer insertion = Integer.parseInt(st.nextToken());
            
            if(instruction.equals("I")){
                dpq.add(insertion);
            } else if (instruction.equals("D") && !dpq.isEmpty()) {
                if(insertion == 1){
                    dpq.pollLast();
                } else {
                    dpq.pollFirst();
                }
            }
        }
        
        if(dpq.isEmpty())
            return new int[]{0,0};
        else
            return new int[]{dpq.last(), dpq.first()};
    }
}