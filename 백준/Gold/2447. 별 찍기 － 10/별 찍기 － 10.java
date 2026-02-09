import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    private int N;
    private char[][] starMatrix;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private void eraseStar(int n){
        if(n<3) return;

        for(int i=0; i<N; i+=n){
            for(int j=0; j<N; j+=n) {
                for (int k = i + n / 3; k < n / 3 * 2 + i; k++){
                    for (int l = j + n / 3; l < n / 3 * 2 + j; l++) {
                        starMatrix[k][l] = ' ';
                    }
                }
            }
        }

        n/=3;
        eraseStar(n);
    }

    private void run(){
        try{
            N = Integer.parseInt(br.readLine());
            starMatrix = new char[N][N];
            
            for(char[] row : starMatrix){
                Arrays.fill(row, '*');
            }

            eraseStar(N);

            for(char[] row : starMatrix){
                for(char c : row){
                    sb.append(c);
                }
                sb.append('\n');
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