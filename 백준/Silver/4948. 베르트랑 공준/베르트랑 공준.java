import java.util.*;
import java.io.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    private boolean[] isPrime;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        isPrime = new boolean[246913];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }

    private void calPrime(){
        for(int i=2; i*i<=246912; i++){
            if(isPrime[i]) for(int j=i*i; j<=246912; j+=i){
                isPrime[j] = false;
            }
        }
    }

    private int countPrime(int start, int end){
        int cnt = 0;
        for(int i=start+1; i<=end; i++){
            if(isPrime[i])
                cnt++;
        }
        return cnt;
    }

    private void run(){
        calPrime();
        try{
            while(true){
                int n = Integer.parseInt(br.readLine());
                if(n==0) break;
                sb.append(countPrime(n, 2*n) + "\n");
            }
            System.out.print(sb);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Main().run();
    }

}