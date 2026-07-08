import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        HashMap<Integer, Integer> examinee = new HashMap<>();
        
        // 정답 개수 초기화
        for(int i=1; i<=3; i++)
            examinee.put(i, 0);
        
        // 답안을 담을 임시변수
        int temp;
        
        // 수포자 답안지 기록 및 채점
        for(int i=0; i<answers.length; i++){
            // 1번 수포자
            temp = i%5+1;
            if(temp == answers[i])
                examinee.put(1, examinee.get(1)+1);
            
            // 2번 수포자
            if(i%2==0){
                temp = 2;
            } else {
                switch(i%8){
                        case 1 -> temp = 1;
                        case 3 -> temp = 3;
                        case 5 -> temp = 4;
                        case 7 -> temp = 5;
                }
            }
            if(temp == answers[i])
                examinee.put(2, examinee.get(2)+1);
            
            // 3번 수포자
            switch((i%10)/2){
                    case 0 -> temp = 3;
                    case 1 -> temp = 1;
                    case 2 -> temp = 2;
                    case 3 -> temp = 4;
                    case 4 -> temp = 5;
            }
            if(temp == answers[i])
                examinee.put(3, examinee.get(3)+1);
        }
        
        ArrayList<Integer> highScoreStudents = new ArrayList<>();
        int max = -1;
        
        for(int i=1; i<=3; i++){
            max = (examinee.get(i) > max) ? examinee.get(i) : max;
        }
        
        for(int i=1; i<=3; i++){
            if(examinee.get(i) == max)
                highScoreStudents.add(i);
        }
        
        
        int[] answer = new int[highScoreStudents.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = highScoreStudents.get(i);
        
        return answer;
    }
}