import java.util.*;

class Solution {
    
    private HashSet<Integer> set;
    private StringBuilder sb;
    private boolean[] visited;
    
    public Solution(){
        set = new HashSet<>();
        sb = new StringBuilder();
    }
    
    private void perm(String numbers, int len){
        
        // StringBuilder가 가득 차면 집합에 올리기
        if(sb.length() == len){
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            
            sb.append(numbers.charAt(i));
            visited[i] = true;
            perm(numbers, len);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2 == 0) return false;
        
        for(int i=3; i*i <= n; i+=2)
            if(n%i == 0) return false;
        
        return true;
    }
    
    public int solution(String numbers) {
        
        // false로 자동 초기화
        visited = new boolean [numbers.length()];
        
        // 순열을 통해 숫자 모으기
        // 1자리부터 n자리까지 모두 만들기
        for(int len=1; len<= numbers.length(); len++){
            perm(numbers, len);
        }
        
        
        // 집합 순회 후 최종개수만 남기기
        int answer = 0;
        for(int n : set){
            if(isPrime(n))
                answer++;
        }
        
        return answer;
    }
}