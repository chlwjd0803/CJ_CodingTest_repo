import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.offerLast(s.charAt(i));
            else if(!stack.isEmpty() && stack.peekLast() == '(')
                stack.pollLast();
            else{
                stack.offerLast(s.charAt(i));
                break;
            }
        }
        
        return stack.isEmpty();
    }
}