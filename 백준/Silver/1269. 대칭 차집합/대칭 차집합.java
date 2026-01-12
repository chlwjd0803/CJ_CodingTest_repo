import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Set<Integer> s1;
    private Set<Integer> s2;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        s1 = new HashSet<>();
        s2 = new HashSet<>();
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                s1.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                s2.add(Integer.parseInt(st.nextToken()));
            }

            Set<Integer> diff1 = new HashSet<>(s1);
            diff1.removeAll(s2);
            Set<Integer> diff2 = new HashSet<>(s2);
            diff2.removeAll(s1);

            diff1.addAll(diff2);

            System.out.print(diff1.size());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}