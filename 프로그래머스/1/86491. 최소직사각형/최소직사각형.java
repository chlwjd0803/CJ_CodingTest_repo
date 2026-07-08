import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        PriorityQueue<Integer> width = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
        
        // 0번 인덱스(가로)에 큰 수가 오도록
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            width.offer(sizes[i][0]);
            height.offer(sizes[i][1]);
        }
        
        return width.poll() * height.poll();
    }
}