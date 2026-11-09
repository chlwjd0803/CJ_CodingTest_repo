import java.util.*;

class Solution {
    
    TreeMap<String, Integer> findMap = new TreeMap<>();
    HashMap<Integer, Integer> maxMap = new HashMap<>();
    StringBuilder sb;
    
    private void rec(int depth, int cour, String order, int start){
        
        // 해당 코스요리수만큼 채웠을때
        if(depth==cour){
            if(findMap.get(sb.toString()) != null){
                findMap.put(sb.toString(), findMap.get(sb.toString())+1);
            } else {
                findMap.put(sb.toString(), 1);
            }
            return;
        }
        
        // 조합 만들어가기
        for(int i=start; i<order.length(); i++){
            sb.append(order.charAt(i));
            rec(depth+1, cour, order, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        // 각 주문별로 나누기
        for(String order : orders){
            
            // 반드시 정렬이 필요함, 해당 형식 기억하기
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            order = new String(arr);
            
            // 코스의 개수별로 문자열 조합하기
            for(int cour : course){
                
                sb = new StringBuilder();
                rec(0, cour, order, 0);
            }
        }
        
        // 코스개수 별 빈도 최대를 기록하기 위해 순회
        for(String comb : findMap.keySet()){
            int length = comb.length();
            // 최대개수가 기록되있지 않으면 최초기록
            if(maxMap.get(length) == null){
                maxMap.put(length, findMap.get(comb));
            } else if(maxMap.get(length) < findMap.get(comb)){
                // 이미 기록되어있다면 더 커졌을때 바꿈
                maxMap.put(length, findMap.get(comb));
            }
            
        }
        
        for(String comb : findMap.keySet()){
            if(findMap.get(comb) >= 2 && maxMap.get(comb.length()).equals(findMap.get(comb))){
                answer.add(comb);
            }
        }
        
        String[] result = new String[answer.size()];
        
        for(int i=0; i<answer.size(); i++)
            result[i] = answer.get(i);
        
        return result;
    }
}