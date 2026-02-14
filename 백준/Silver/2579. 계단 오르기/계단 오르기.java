import java.io.*;
import java.util.*;

public class Main {

    private BufferedReader br;

    private int[] stairs;
    private int[][] cumulative;

    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void solve(){
        try{
            n = Integer.parseInt(br.readLine());

            stairs = new int[n];
            // 상태 두가지를 저장하기 위함, 0->2계단, 1->연속해서 옴
            cumulative = new int[n][2];

            for(int i = 0; i < n; i++){
                stairs[i] = Integer.parseInt(br.readLine());
            }

            cumulative[0][0] = stairs[0];
            cumulative[0][1] = stairs[0];
            for(int i = 1; i < n; i++){
                if(i==1){
                    cumulative[i][0] = stairs[i];
                } else{
                    cumulative[i][0] = Math.max(cumulative[i-2][0], cumulative[i-2][1]) + stairs[i];
                }
                cumulative[i][1] = cumulative[i-1][0] + stairs[i];
            }

            System.out.print(Math.max(cumulative[n-1][0], cumulative[n-1][1]));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}