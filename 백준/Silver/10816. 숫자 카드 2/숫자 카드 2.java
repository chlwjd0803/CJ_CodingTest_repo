import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Map<Integer, Integer> map;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        map = new HashMap<>();
    }


    private void run(){
        try{
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                int card = Integer.parseInt(st.nextToken());
                if(map.containsKey(card)){
                    map.put(card, map.get(card)+1);
                } else {
                    map.put(card, 1);
                }
            }

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                int checkCard = Integer.parseInt(st.nextToken());

                if(map.containsKey(checkCard)){
                    sb.append(map.get(checkCard) + " ");
                } else {
                    sb.append("0 ");
                }
            }
            System.out.print(sb);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }

}