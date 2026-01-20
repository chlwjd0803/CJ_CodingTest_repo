import java.io.*;
import java.util.*;

public class Main {

    private BufferedReader br;
    private StringTokenizer st;

    private int[] A;
    private int[] tmp;
    private int n;
    private int k;
    private int cnt;
    private int result;

    public Main() {
        br = new BufferedReader(new InputStreamReader(System.in));
        cnt = 0;
        result = -1;
    }

    private void mergeSort(int p, int r){
        if(p<r && (result==-1)){
            int q = (p+r)/2;
            mergeSort(p, q);
            mergeSort(q+1, r);
            merge(p, q, r);
        }
    }

    private void merge(int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = 0;

        if(result!=-1) return;

        while(i<=q && j<=r){
            tmp[t++] = (A[i]<=A[j]) ? A[i++] : A[j++];
        }
        while(i<=q) {
            tmp[t++] = A[i++];
        }
        while(j<=r) {
            tmp[t++] = A[j++];
        }
        i=p;
        t=0;
        while(i<=r) {
            A[i++] = tmp[t++];
            if(++cnt == k)
                result = A[i-1];
        }
    }

    private void solve(){
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            A = new int[n];
            tmp = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            mergeSort(0, n-1);
            System.out.print(result);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}