import java.io.*;
import java.util.*;

class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2){
        if(s1.length() != s2.length()){
            return s1.length() - s2.length();
        } else {
            return s1.compareTo(s2);
        }
    }
}


public class Main {

    private BufferedReader br;
    private StringBuilder sb;

    private Set<String> strs;
    private int n;


    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        strs = new TreeSet<>(new CustomComparator());
    }

    private void input(){
        try{
            n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                strs.add(br.readLine());
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void print(){
        for(String s : strs){
            sb.append(s);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private void run(){
        input();
        print();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}