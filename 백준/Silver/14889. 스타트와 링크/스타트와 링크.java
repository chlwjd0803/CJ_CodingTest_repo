import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;

    // 팀 집합
    private boolean[] isHome;

    // 점수 배열
    private int[][] score;
    // 사람 수
    private int num;
    // 최소 차이
    private int min;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
    }

    private int calculate(){
        int sum = 0;

        for(int i=0; i<num; i++){
            for(int j=i+1; j<num; j++){
                if(isHome[i] && isHome[j]) // 둘다 홈팀
                    sum += score[i][j] + score[j][i];
                if(!isHome[i] && !isHome[j]) // 둘다 원정팀
                    sum -= score[i][j] + score[j][i];
                // 그 외는 계산하지 않음
            }
        }
        return Math.abs(sum);
    }


    private void split(int teamCount, int startIdx){
        if(teamCount == num/2){
            // 팀 점수 계산
            min = Math.min(calculate(), min);
            return;
        }

        for(int i=startIdx; i<num; i++){
            // 홈팀 추가
            isHome[i] = true;
            split(teamCount+1, i+1);
            // 홈팀에서 제거
            isHome[i] = false;
        }
    }
    
    private void run(){
        try{
            // 4~20 사이의 사람 입력
            num = Integer.parseInt(br.readLine());
            score = new int[num][num];

            // 인원 수 만큼 홈팀인지 원정팀인지 여부 초기화
            isHome = new boolean[num];
            Arrays.fill(isHome, false); // 일단 모두 원정팀으로 초기화

            // 점수판 입력받기
            for(int i=0; i<num; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<num; j++){
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            split(0, 0);

            System.out.print(min);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}