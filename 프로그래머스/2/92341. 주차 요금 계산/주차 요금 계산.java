import java.util.*;

class Solution {
    
    // 시간 저장
    TreeMap<String, Integer> totalCars = new TreeMap<>();
    TreeMap<String, int[]> currentCars = new TreeMap<>();
    
    StringTokenizer st;
    
    // 기본시간, 기본요금, 단위시간, 단위요금
    int defTime;
    int defFee;
    int perTime;
    int perFee;
    

    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        defTime = fees[0];
        defFee = fees[1];
        perTime = fees[2];
        perFee = fees[3];
        
        
        for(String r : records){
            st = new StringTokenizer(r, " :");
            
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            String carNum = st.nextToken();
            boolean isIn = st.nextToken().equals("IN");
            
            if(isIn){
                currentCars.put(carNum, new int[] {hour, min});
            } else {
                // 들어왔을떄 기록 시 분
                int[] temp = currentCars.get(carNum);
                // 사용 시간, 나갈때 시간에서 들어올때 시간 빼기.
                int duringTime = (hour - temp[0]) * 60 + (min - temp[1]);
                
                // 이미 차가 있으면 더하기
                if(totalCars.containsKey(carNum)){
                    totalCars.put(carNum, totalCars.get(carNum) + duringTime);
                } else {
                    totalCars.put(carNum, duringTime);
                }
                
                // 현재 현황에서 지우기
                currentCars.remove(carNum);
            }
        }
        
        // 남은 차들 아웃 (23:59)
        for(String carNum : currentCars.keySet()){
            // 들어왔을떄 기록 시 분
            int[] temp = currentCars.get(carNum);
            // 사용 시간, 나갈때 시간에서 들어올때 시간 빼기.
            int duringTime = (23 - temp[0]) * 60 + (59 - temp[1]);
                
            // 이미 차가 있으면 시간 더하기
            if(totalCars.containsKey(carNum)){
                totalCars.put(carNum, totalCars.get(carNum) + duringTime);
            } else {
                totalCars.put(carNum, duringTime);
            }
        }
        
        
        for(String carNum : totalCars.keySet()){
            // 총 주차시간
            int duringTime = totalCars.get(carNum);
            // 총 요금 반영과정
            int totalFee = (duringTime>defTime) ? ((int) Math.ceil((double)(duringTime-defTime)/perTime)*perFee) : 0;
            totalFee += defFee; // 기본 요금 반영(1분이상 주차했으므로)

            answer.add(totalFee);
        }
        
        int[] result = new int[answer.size()];
        
        for(int i=0; i<answer.size(); i++)
            result[i] = answer.get(i);
        
        
        return result;
    }
}