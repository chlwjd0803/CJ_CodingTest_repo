import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--; // 가장 무거운 사람은 배 수용 무게보다 반드시 작거나 같음
            cnt++;
        }
        
        return cnt;
    }
}