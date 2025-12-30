import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private BufferedReader br;
    private PriorityQueue<Integer> pq;
    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void insert(){
        try{
            n = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>(n);

            for(int i=0; i<n; i++){
                pq.add(Integer.parseInt(br.readLine()));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void print(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }

    private void run(){
        insert();
        print();
    }

    public static void main(String[] args){
        new Main().run();
    }

}
