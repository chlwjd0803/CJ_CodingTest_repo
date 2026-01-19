import java.util.*;

public class Main{

    private Scanner sc;

    public Main(){
        sc = new Scanner(System.in);
    }

    private int fibo(int n){
        if(n==0 || n==1)
            return n;
        else
            return fibo(n-1) + fibo(n-2);
    }

    private void run(){
        int n = sc.nextInt();
        System.out.print(fibo(n));
    }

    public static void main(String[] args){
        new Main().run();
    }
}