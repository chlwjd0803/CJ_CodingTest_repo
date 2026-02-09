import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    private int count;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        count = 0;
    }
    
    private void hanoi(int n, int start, int end, int bridge){
        if(n==1){
            sb.append(start + " " + end).append("\n");
            count++;
            return;
        }
        
        hanoi(n-1, start, bridge, end);
        
        sb.append(start + " " + end).append("\n");
        count++;
        
        hanoi(n-1, bridge, end, start);
    }

    private void run(){
        try{
            int n = Integer.parseInt(br.readLine());
            hanoi(n, 1, 3, 2);
            System.out.println(count);
            System.out.print(sb);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}