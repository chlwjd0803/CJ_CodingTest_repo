import java.util.*;
import java.io.*;

public class Main {

    private BufferedReader br;
    private StringTokenizer st;

    public Main() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            if(min >= 45){
                min -= 45;
            } else {
                if(hour == 0) hour = 23;
                else hour--;
                min += 15;
            }

            System.out.print(hour + " " + min);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }

}