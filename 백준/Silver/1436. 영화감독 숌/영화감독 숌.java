import java.util.*;
import java.io.*;

public class Main{

    private BufferedReader br;
    private int input;
    private int count;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            input = Integer.parseInt(br.readLine());
            count = 0;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void run(){
        int index=0;
        String target="";

        while(count!=input){
            target = String.valueOf(index++);
            if(target.contains("666")) count++;
        }

        System.out.print(target);
    }

    public static void main(String[] args){
        new Main().run();
    }
}
