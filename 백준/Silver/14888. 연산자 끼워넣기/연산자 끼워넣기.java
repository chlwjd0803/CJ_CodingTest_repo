import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;

    private int MAX;
    private int MIN;

    private int[] numbers;
    private int[] operatorCount;

    private int totalOperCnt;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        operatorCount = new int[4];
        totalOperCnt = 0;
        MAX = -2147483648;
        MIN = 2147483647;
    }

    /**
     *
     * @param operIdx 어떤 연산자
     * @param cumulative 누적
     * @param numIdx 대상 숫자 인덱스
     * @return 누적
     */
    private int calculate(int operIdx, int cumulative, int numIdx){
        if(operIdx == 0){
            cumulative += numbers[numIdx];
        } else if(operIdx == 1){
            cumulative -= numbers[numIdx];
        } else if(operIdx == 2){
            cumulative *= numbers[numIdx];
        } else if(operIdx == 3){
            cumulative /= numbers[numIdx];
        }

        return cumulative;
    }


    private void solve(int index, int cumulative){
        // 마지막에 다 왔다면 모두 연산된 것이므로
        if(index == numbers.length - 1){
            MAX = Math.max(cumulative, MAX);
            MIN = Math.min(cumulative, MIN);
            return;
        }

        // 0->+ , 1->-, 2->*, 3->/
        for(int i=0; i<4; i++){
            if(operatorCount[i] > 0){
                // 사용했으니 감소
                operatorCount[i]--;
                // 선택한 다음 단계로
                solve(index+1, calculate(i, cumulative, index+1));
                // 복구
                operatorCount[i]++;
            }
        }
    }

    private void run(){
        try{
            // 숫자의 개수 받기
            int numOfNum = Integer.parseInt(br.readLine());

            numbers = new int[numOfNum];

            // 숫자들 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<numOfNum; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 연산자 개수 입력받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                operatorCount[i] = Integer.parseInt(st.nextToken());
                totalOperCnt += operatorCount[i];
            }

            // 누적에 첫 숫자는 넣기
            solve(0, numbers[0]);

            sb.append("" + MAX).append("\n").append("" + MIN);
            System.out.println(sb);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}