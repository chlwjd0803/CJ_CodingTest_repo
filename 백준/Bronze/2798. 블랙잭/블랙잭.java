import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private Scanner sc;
    private int n;
    private int m;
    private int opt;
    private ArrayList<Integer> arr;

    public Main(){
        sc = new Scanner(System.in);
        opt = -1;
    }

    private void insert(){
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList<>(n);

        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
    }

    private void order(){
        int sum;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    sum = arr.get(i) + arr.get(j) + arr.get(k);
                    if((sum > opt) && (sum <= m))
                        opt = sum;

                }
            }
        }
    }

    private void run(){
        insert();
        order();
        System.out.print(opt);
    }

    public static void main(String[] args){
        new Main().run();
    }

}
