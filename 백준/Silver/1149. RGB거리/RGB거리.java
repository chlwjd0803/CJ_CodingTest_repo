import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;

    // 집의 개수
    private int n;

    private int resultMin;

    private int[][] rgb;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        resultMin = Integer.MAX_VALUE;
    }

    private void solve(){
        try{
            n = Integer.parseInt(br.readLine());
            // 2배로 선언
            rgb = new int[n][3];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                // 입력 후 같은 내용을 복사
                rgb[i][0] = Integer.parseInt(st.nextToken());
//                rgb[i+n][0] = rgb[i][0];
                rgb[i][1] = Integer.parseInt(st.nextToken());
//                rgb[i+n][1] = rgb[i][1];
                rgb[i][2] = Integer.parseInt(st.nextToken());
//                rgb[i+n][2] = rgb[i][2];
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        // 동적 프로그래밍
        for(int i=1; i<n; i++){
            rgb[i][0] += Math.min(rgb[i-1][1], rgb[i-1][2]);
            rgb[i][1] += Math.min(rgb[i-1][0], rgb[i-1][2]);
            rgb[i][2] += Math.min(rgb[i-1][0], rgb[i-1][1]);
        }

        resultMin = Math.min(rgb[n-1][0], Math.min(rgb[n-1][1], rgb[n-1][2]));
        

        System.out.print(resultMin);
    }

    public static void main(String[] args){
        new Main().solve();
    }

}