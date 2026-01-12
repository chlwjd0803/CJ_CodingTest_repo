import java.util.*;
import java.io.*;

class Position{

    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getY() {return y;}

    public Integer getX() {return x;}

}


public class Main{

    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;
    private List<Position> pos;

    private int n;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private void input(){
        try{
            n = Integer.parseInt(br.readLine());
            pos = new ArrayList<>(n);

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                pos.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // 알고리즘 교과목 컬렉션 부분 비교 단원 참고
    private void sort(){
        pos.sort(Comparator.comparingInt(Position::getY)
                .thenComparingInt(Position::getX));
    }

    private void print(){
        for(int i=0; i<n; i++){
            sb.append(pos.get(i).getX() + " " + pos.get(i).getY());
            if(i<n-1) sb.append("\n");
        }
        System.out.print(sb);
    }

    private void run(){
        input();
        sort();
        print();
    }

    public static void main(String[] args){
        new Main().run();
    }

}