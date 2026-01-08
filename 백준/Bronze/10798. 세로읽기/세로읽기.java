import java.io.*;
import java.util.*;

public class Main {
    private BufferedReader br;
    private StringBuilder sb;
    private char[][] ch;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        ch = new char[5][15];
    }

    private void run(){
        try{
            for(int i=0; i<5; i++){
                String input = br.readLine();
                for(int j=0; j<15; j++){
                    if(input.length() > j)
                        ch[i][j] = input.charAt(j);
                    else
                        ch[i][j] = 0;
                }
            }

            for(int j=0; j<15; j++){
                for(int i=0; i<5; i++){
                    if(ch[i][j] == 0)
                        continue;
                    sb.append(ch[i][j]);
                }
            }

            System.out.print(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}