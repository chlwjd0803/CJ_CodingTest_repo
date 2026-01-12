import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Set<Integer> set;

    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        set = new HashSet<>();
    }

    private void run(){
        try{
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                set.add(Integer.parseInt(st.nextToken()));
            }

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1 ");
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