import java.util.*;
import java.io.*;

public class Main {

    private BufferedReader br;
    private StringTokenizer st;
    private Set<String> set;

    private int count;
    
    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        count = 0;
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=0; i<n; i++){
                set.add(br.readLine());
            }

            for(int i=0; i<m; i++){
                count += (set.contains(br.readLine())) ? 1 : 0;
            }

            System.out.print(count);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}