import java.util.*;
import java.io.*;

public class Main {

    private BufferedReader br;
    private int input;
    private int output;

    public Main(){
        
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            input = Integer.parseInt(br.readLine());
        } catch (Exception e){
            e.printStackTrace();
        }
        output = 0;
    }

    private void run(){

        for(int i=1; i<input; i++){
            int sum = 0;
            int temp = i;

            sum += temp;
            while(temp > 0){
                sum += temp - ((temp / 10) * 10);
                temp /= 10;
            }

            if(sum == input){
                output = i;
                break;
            }
        }

        System.out.print(output);

    }

    public static void main(String[] args) {
        new Main().run();
    }
}