import java.io.*;
import java.util.*;

public class Main{

    private Scanner sc;

    private int[][] chess;

    private int input;
    private int result;

    public Main(){
        sc = new Scanner(System.in);
        input = sc.nextInt();
        chess = new int[input][input];

        for(int i=0; i<input; i++){
            Arrays.fill(chess[i], 0);
        }
        result = 0;
    }

    private void toggle(int i, int j, int avail){
        int k, l;
        
        for(k=0; k<input; k++){
            chess[i][k] += avail;
            chess[k][j] += avail;
        }
        chess[i][j] -= avail;
        
        k = i;
        l = j;
        while(k>0 && l>0){
            chess[--k][--l] += avail;
        }
        
        k = i;
        l = j;
        while(k>0 && l<input-1){
            chess[--k][++l] += avail;
        }
        
        k = i;
        l = j;
        while(k<input-1 && l>0){
            chess[++k][--l] += avail;
        }
        
        k = i;
        l = j;
        while(k<input-1 && l<input-1){
            chess[++k][++l] += avail;
        }
    }

    private void search(int row){
        if(row == input){
            result ++;
            return;
        }

        for(int j=0; j<input; j++){
            if(chess[row][j] == 0){
                toggle(row, j, 1);
                search(row+1);
                toggle(row, j, -1);
            }
        }

    }

    private void run(){
        search(0);
        System.out.print(result);
    }

    public static void main(String[] args){
        new Main().run();
    }
}