import java.io.*;
import java.util.*;


public class Main{

    private BufferedReader br;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private long fact(long n){
        if(n>0)
            return n * fact(n-1);
        else
            return 1;
    }

    private void run(){
        try{
            long n = Integer.parseInt(br.readLine());
            System.out.print(fact(n));
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args){
        new Main().run();
    }
}