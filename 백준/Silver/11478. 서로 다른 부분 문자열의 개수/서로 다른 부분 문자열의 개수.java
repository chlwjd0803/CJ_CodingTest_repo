import java.io.*;
import java.util.*;

public class Main{
    private BufferedReader br;

    private Set<String> set;
    private String input;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
    }

    private void run(){
        try{
            input = br.readLine();

            for(int i=1; i<=input.length(); i++){
                for(int j=0; j<=input.length()-i; j++){
                    set.add(input.substring(j, j+i));
                }
            }
            System.out.print(set.size());

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}