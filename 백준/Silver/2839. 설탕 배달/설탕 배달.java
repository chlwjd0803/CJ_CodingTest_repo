import java.io.*;
import java.util.*;

public class Main {

    private BufferedReader br;
    private int min;
    private int input;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
          input = Integer.parseInt(br.readLine());
        } catch (Exception e){
          e.printStackTrace();
        }

        min = -1;
    }

    private void run(){

        for(int x=0; 3*x <= input; x++)
            for(int y=0; 5*y <= input-(3*x); y++)
                if(5*y == input-(3*x) && ((min == -1) || (min>(x+y))))
                    min = x+y;
        
        System.out.print(min);
    }

    public static void main(String[] args){
        new Main().run();
    }
}