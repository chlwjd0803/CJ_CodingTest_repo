import java.io.*;
import java.util.*;


public class Main{

    private BufferedReader br;
    private StringTokenizer st;

    private boolean[][] board;

    private int row;
    private int col;
    private int min;
    private int cnt;
    private boolean isWhite;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            min = 2500;

            board = new boolean[row][col];

            for(int i=0; i<row; i++){
                String line = br.readLine();
                for(int j=0; j<col; j++){
                    board[i][j] = line.charAt(j) == 'W';
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private int checkBoard(int i, int j){

        cnt = 0;

        for(int k=i; k<i+8; k++){
            for(int l=j; l<j+8; l++){
                if(board[k][l] != isWhite)
                    cnt++;
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }

        return cnt;
    }


    private void run(){

        for(int i=0; i<=row-8; i++){
            for(int j=0; j<=col-8; j++){
                isWhite = board[i][j];
                int forward = checkBoard(i, j);

                isWhite = !isWhite;
                int reverse = checkBoard(i, j);

                if(forward < reverse){
                    min = Math.min(min, forward);
                } else {
                    min = Math.min(min, reverse);
                }
            }
        }

        System.out.print(min);
    }

    public static void main(String[] args){
        new Main().run();
    }

}