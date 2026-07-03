import java.util.*;

class Solution {
    
    private Queue<int[]> allJobs;
    private Queue<int[]> readyJobs;
    
    public Solution(){
        allJobs = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> a[1])
        );
        
        readyJobs = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> a[2])
                .thenComparingInt(a -> a[1])
                .thenComparingInt(a -> a[0])
        );
    }
    
    public int solution(int[][] jobs) {
        
        for(int i=0; i<jobs.length; i++)
            allJobs.offer(new int[]{i, jobs[i][0], jobs[i][1]});
        
        
        int time = 0;
        int sumTime = 0;
        int startTime = -1;
        int finishTime = -1;
        
        while(!allJobs.isEmpty() || startTime > -1){
            
            // 현재 작업이 끝난 시기라면
            // 이걸 먼저 실행하지 않으면 1ms를 흘려보내게됨
            if(finishTime == time){
                // 초기화
                startTime = -1;
                finishTime = -1;
            }
            
            // 대기열 큐에 넣을게 있는지 확인
            while(!allJobs.isEmpty() && allJobs.peek()[1] == time)
                readyJobs.offer(allJobs.poll());
            
            // 현재 작업이 비는 상태면 
            if(startTime==-1 && !readyJobs.isEmpty()){
                int[] job = readyJobs.poll();
                // 시작시간, 끝시간 미리 계산하고 시간 누적
                startTime = time;
                finishTime = startTime + job[2];
                sumTime += finishTime - job[1];
            }
            // 위에서 끝내고 작업이 빌때 바로 점유해야 정답이 나옴
            
            time++;
        }

        return sumTime / jobs.length;
    }
}