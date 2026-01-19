import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Comp1 implements Comparator<String> {
    public int compare(String s1, String s2) {
        return Main.hm.get(s2) - Main.hm.get(s1);
    }
}

class Comp2 implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
}

class Comp3 implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}

public class Main {

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    public static HashMap<String, Integer> hm;
    public static TreeSet<String> ts;

    public Main(){
        ts = new TreeSet<>(new Comp1().thenComparing(new Comp2().thenComparing(new Comp3())));
        hm = new HashMap<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++){
                String s = br.readLine();
                if(s.length() >= len){
                    if(hm.containsKey(s))
                        hm.put(s, hm.get(s) + 1);
                    else
                        hm.put(s, 1);
                }
            }

            hm.forEach((s, i) -> ts.add(s));

            ts.forEach((s) -> sb.append(s).append("\n"));

            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}