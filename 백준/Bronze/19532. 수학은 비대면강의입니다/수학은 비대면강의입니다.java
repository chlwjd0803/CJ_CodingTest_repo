import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private int x;
    private int y;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public Main(){

        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());
        } catch(Exception e){
            e.printStackTrace();
        }
    }



    private void run(){
        for(x=-999; x<=999; x++){
            for(y=-999; y<=999; y++){
                if((a*x + b*y == c) && (d*x + e*y == f)){
                    System.out.print(x + " " + y);
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}