import java.util.*;
import java.io.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private boolean[] isPrime;

    private final int MAX_NUM = 1000000;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        isPrime = new boolean[MAX_NUM + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }

    private void calPrime(){
        for(int i=2; i*i<=MAX_NUM; i++){
            if(isPrime[i]) for(int j=i*i; j<=MAX_NUM; j+=i){
                isPrime[j] = false;
            }
        }
    }

    private void printPrime(int start, int end){
        for(int i=start; i<=end; i++){
            if(isPrime[i]){
                sb.append(i + "\n");
            }
        }
    }

    private void run(){
        calPrime();
        try{
            st = new StringTokenizer(br.readLine());
            printPrime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            System.out.print(sb);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }

}