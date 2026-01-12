import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Set<Integer> set;
    private Map<Integer, Integer> map;

    private int[] arr;
    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        set = new TreeSet<>();
        map = new HashMap<>();
    }

    private void input(){
        try{
            n = Integer.parseInt(br.readLine());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int target = Integer.parseInt(st.nextToken());
                arr[i] = target;
                set.add(target);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void mapping(){
        int index = 0;
        for(Integer num : set){
            map.put(num, index++);
        }
    }

    private void print(){
        for(int i=0; i<n; i++){
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.print(sb);
    }

    private void run(){
        input();
        mapping();
        print();
    }

    public static void main(String[] args){
        new Main().run();
    }
}