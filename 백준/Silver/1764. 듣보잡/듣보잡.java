import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Set<String> s1;
    private Set<String> s2;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        s1 = new TreeSet<>();
        s2 = new TreeSet<>();
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            for(int i=0; i<n; i++){
                s1.add(br.readLine());
            }

            n = Integer.parseInt(st.nextToken());
            for(int i=0; i<n; i++){
                s2.add(br.readLine());
            }

            s1.retainAll(s2);

            sb.append(s1.size() + "\n");
            for(String name : s1){
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