import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;

    private final long MOD = 1000000000;

    private long[][] dp;
    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void solve(){
        try{
            n = Integer.parseInt(br.readLine());
            // n+1의 길이의 숫자, 0~9의 맨뒷자리수
            dp = new long[n+1][10];

            // 1개일때만
            for(int i=1; i<=9; i++){
                dp[1][i] = 1;
            }

            // 2자리수 이상
            for(int i=2; i<=n; i++){
                for(int j=0; j<=9; j++){
                    if(j==0){ // 맨뒷자리의 수가 0일때와
                        dp[i][j] = dp[i-1][1] % MOD; // 0이면 다음의 계단수는 1밖에 없음
                    } else if(j==9){ // 맨뒷자리의 수가 9일때는 하나만 가능
                        dp[i][j] = dp[i-1][8] % MOD; // 9면 다음의 계단수는 8밖에 없음. 0이면 숫자가 넘어감
                    } else{ // 그 사이면 둘다 가능
                        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD; // 마지막 자릿수의 +-1이 모두 가능함
                    }
                }
            }

            long result = 0;
            for(int i=0; i<=9; i++){
                result += dp[n][i] % MOD;
            }

            System.out.print(result % MOD);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        new Main().solve();
    }
}