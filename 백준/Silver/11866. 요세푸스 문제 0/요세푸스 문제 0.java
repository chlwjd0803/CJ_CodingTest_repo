import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class MyArrayList<E> extends ArrayList<E> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        int i;
        for(i = 0; i < size()-1; i++) {
            sb.append(get(i)).append(", ");
        }
        sb.append(get(i));
        sb.append(">");

        return sb.toString();
    }
}

public class Main {

    private BufferedReader br;
    private StringTokenizer st;

    private Deque<Integer> dq;
    private List<Integer> list;

    public Main() {
        br = new BufferedReader(new InputStreamReader(System.in));
        dq = new ArrayDeque<>();
        list = new MyArrayList<>();
    }

    private void run(){
        try{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int i = 0; i< n; i++)
                dq.addLast(i+1);

            int cnt = 0;
            while(!dq.isEmpty()){
                int temp = dq.pollFirst();
                if(++cnt == k) {
                    list.add(temp);
                    cnt = 0;
                }
                else
                    dq.addLast(temp);
            }

            System.out.print(list.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}