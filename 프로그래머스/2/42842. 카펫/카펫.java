class Solution {
    public int[] solution(int brown, int yellow) {
        
        int h = 2;
        // 반복문을 실행하기 위한 임시 할당
        int w = brown+yellow;
        
        while(w >= h){
            
            if((brown+yellow)%(++h)!=0)
                continue;
            
            w = (brown+yellow) / h;
            
            if(((w-2)*(h-2)==yellow) && (w*h==brown+yellow))
                break;
            
        }
        
        int[] answer = new int[]{w, h};
        return answer;
    }
}