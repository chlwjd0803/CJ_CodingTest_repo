import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    private int cnt;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private int rec(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else {
            ++cnt;
            return rec(s, l + 1, r - 1);
        }
    }

    private int isPali(String s){
        cnt = 1;
        return rec(s, 0, s.length()-1);
    }

    private void solve(){
        try{
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                sb.append(isPali(br.readLine()) + " " + cnt + "\n");
            }
            System.out.print(sb);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }

}