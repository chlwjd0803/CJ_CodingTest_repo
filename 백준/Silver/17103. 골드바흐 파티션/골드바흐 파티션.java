import java.io.*;
import java.util.*;

public class Main{

    private BufferedReader br;
    private StringBuilder sb;

    private List<Integer> list;

    private boolean[] isPrime;
    private int t;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        list = new ArrayList<>();
        isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }

    private void makePrimeList(){

        for(int i=2; i*i<=1000000; i++){
            if(isPrime[i]) for(int j=i*i; j<=1000000; j+=i){
                isPrime[j] = false;
            }
        }

        for(int i=2; i<=1000000; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }
    }

    private int doTestCase(int n){
        int cnt = 0;
        int left = 0;
        int right = list.size()-1;

        while(left<=right){
            if(list.get(left)+list.get(right) == n){
                cnt++;
                left++;
                right--;
            }
            else if(list.get(left)+list.get(right) < n){
                left++;
            }
            else{
                right--;
            }
        }

//        for(int i=0; i<list.size(); i++){
//            for(int j=i; j<list.size() && (list.get(i) + list.get(j) <= n); j++){
//                if(list.get(i) + list.get(j) == n)
//                    cnt++;
//            }
//        }
        return cnt;
    }

    private void run(){
        makePrimeList();

        try{
            t = Integer.parseInt(br.readLine());

            for(int i=0; i<t; i++){
                sb.append(doTestCase(Integer.parseInt(br.readLine())) + "\n");
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

