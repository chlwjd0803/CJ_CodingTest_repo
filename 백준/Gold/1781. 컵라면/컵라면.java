import java.io.*;
import java.util.*;

class Homework implements Comparable<Homework>{
    private int deadline;
    private int ramyun;

    public Homework(int deadline, int ramyun){
        this.deadline = deadline;
        this.ramyun = ramyun;
    }

    public int getDeadline(){
        return deadline;
    }

    public int getRamyun(){
        return ramyun;
    }

    @Override
    public int compareTo(Homework that){
        return this.deadline - that.deadline;
    }
}


public class Main {

    private BufferedReader br;
    private StringTokenizer st;

    private List<Homework> homeworks;
    private Queue<Integer> pq;

    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>();
        homeworks = new ArrayList<>();
    }

    public void run(){
        try{
            n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                homeworks.add(new Homework(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())));
            }
            Collections.sort(homeworks);

            for(Homework hw : homeworks){
                if(hw.getDeadline() > pq.size()){
                    pq.add(hw.getRamyun());
                } else {
                    if(pq.peek() < hw.getRamyun()){
                        pq.poll();
                        pq.add(hw.getRamyun());
                    }
                }
            }

            int total = 0;
            for(Integer ram : pq){
                total += ram;
            }
            System.out.println(total);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}