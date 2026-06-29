import java.util.*;

class Solution {
    
    private Set<Integer> set;
    
    public Solution(){
        set = new HashSet<>();
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        // 종류의 수보다 N/2가 적다면 N/2를 반환
        return (set.size() > nums.length/2) ? nums.length/2 : set.size();
    }
}