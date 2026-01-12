import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Set<String> set;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        set = new TreeSet<>(Collections.reverseOrder());
    }

    private void run(){
        try{
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String status = st.nextToken();
                if(status.equals("enter")){
                    set.add(name);
                } else if(status.equals("leave")){
                    set.remove(name);
                } else {
                    throw new IllegalArgumentException();
                }
            }

            for(String name : set){
                sb.append(name + "\n");
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