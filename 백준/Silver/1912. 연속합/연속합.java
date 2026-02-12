import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;

    // 최대
    private int max = Integer.MIN_VALUE;
    // 입력 숫자 개수
    private int n;
    // 입력 숫자 배열
    private int[] arr;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void solve(){
        try{
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];

            // 만약 누계합보다 배열 값이 더 크다면 그 값으로 초기화
            if(sum < arr[i])
                sum = arr[i];
            // 최대값 갱신
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }

    public static void main(String[] args){
        new Main().solve();
    }
}