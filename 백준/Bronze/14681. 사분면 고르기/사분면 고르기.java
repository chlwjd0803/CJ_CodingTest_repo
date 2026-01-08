import java.util.*;
import java.io.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private int check(int x, int y){
        return (x>0 && y>0) ? 1
                : (x<0 && y>0) ? 2 
                : (x<0 && y<0) ? 3
                : (x>0 && y<0) ? 4
                : 0;
    }

    private void run(){
        try{
            System.out.print(check(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }

}