import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Map<String, String> map;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        map = new HashMap<>();
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=1; i<=n; i++){
                String pokemonName = br.readLine();
                map.put(i+"", pokemonName);
                map.put(pokemonName, i+"");
            }

            for(int i=0; i<m; i++) {
                sb.append(map.get(br.readLine()) + "\n");
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