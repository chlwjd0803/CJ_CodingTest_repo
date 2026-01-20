import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    private char[] kanto;
    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }
    
    private void erase(int stast, int len, int endst){
        for(int i=stast+len; i<endst; i++)
            kanto[i] = ' ';
        if(len==1) return;
        erase(stast, len/3, stast+len/3*2);
        erase(endst, len/3, endst+len/3*2);
    }

    private void solve(){
        try{
            String input;
            while((input = br.readLine()) != null){
                n = (int)Math.pow(3, Integer.parseInt(input));
                if(n==1){
                    sb.append("-").append("\n");
                } else {
                    kanto = new char[n];
                    for(int i=0; i<n; i++)
                        kanto[i] = '-';
                    erase(0, n/3, n/3*2);
                    sb.append(new String(kanto)).append("\n");
                }
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