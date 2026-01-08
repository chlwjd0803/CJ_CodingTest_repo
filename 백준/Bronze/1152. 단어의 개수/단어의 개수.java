import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;

    public Main(){
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void run(){
        System.out.print(st.countTokens());
    }

    public static void main(String[] args){
        new Main().run();
    }

}