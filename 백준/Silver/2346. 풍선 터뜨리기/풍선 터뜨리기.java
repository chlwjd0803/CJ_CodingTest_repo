import java.util.*;
import java.io.*;

public class Main {

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Deque<Integer> deq;

    private int n;

    private int[] paper;

    public Main() {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        deq = new ArrayDeque<>();
    }

    private void run(){
        try{
            n = Integer.parseInt(br.readLine());
            paper = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                paper[i] = Integer.parseInt(st.nextToken());
                deq.offerLast(i);
            }

            int target = deq.pollFirst();
            sb.append(target + " ");
            while(!deq.isEmpty()){
                int move = paper[target];
                if(move > 0){
                    while(move --> 0){
                        deq.offerLast(deq.pollFirst());
                    }
                    target = deq.pollLast();
                } else {
                    while(move ++< 0){
                        deq.offerFirst(deq.pollLast());
                    }
                    target = deq.pollFirst();
                }
                sb.append(target + " ");
            }
            System.out.println(sb);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}