import java.util.*;

class Solution {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        
        for(int i=1; i<=8; i++){
            HashSet<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            
            // 1. 기본적으로 이어붙인 나열값 넣기
            for(int j=0; j<i; j++)
                sb.append(N);
            set.add(Integer.parseInt(sb.toString()));
             
            // 2. i의 앞전 계산을 순회
            for(int j=1; j<i; j++){
                for(int x : dp.get(j-1)){
                    for(int y : dp.get(i-j-1)){
                        set.add(x+y);
                        set.add(x-y);
                        set.add(x*y);
                        if(y!=0)
                            set.add(x/y);
                    }
                }
            }
            dp.add(set);
        }
        
        
        int answer = -1;
        for(int i=0; i<8; i++){
            if(dp.get(i).contains(number))
                return i+1;
        }
        return answer;
    }
}