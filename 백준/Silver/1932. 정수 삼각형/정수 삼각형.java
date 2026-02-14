import java.io.*;
import java.util.*;

public class Main {

    private BufferedReader br;
    private StringTokenizer st;

    private int[][] triangles;

    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void solve(){
        try{
            n = Integer.parseInt(br.readLine());

            triangles = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < i+1; j++){
                    triangles[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(j==0){
                    triangles[i][j] += triangles[i-1][j];
                } else if(j==i){
                    triangles[i][j] += triangles[i-1][j-1];
                } else{
                    triangles[i][j] += Math.max(triangles[i-1][j-1], triangles[i-1][j]);
                }
            }
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(result, triangles[n-1][i]);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException{
        new Main().solve();
    }
}