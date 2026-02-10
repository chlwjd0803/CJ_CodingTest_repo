import java.io.*;
import java.util.*;

class Position{

    private int row;
    private int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

public class Main{

    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;

    private List<Position> blankList;

    private int[][] sudoku;

    private boolean endFlag;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        endFlag = false;
        blankList = new ArrayList<>();

        sudoku = new int[9][9];

        for(int[] row : sudoku){
            Arrays.fill(row, 0);
        }
    }

    private boolean search(int row, int col, int n){

        // 사각형 출발지점
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        // 사각형
        for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                // 넣으려는 숫자가 사각형 내부에 존재할 경우
                if(sudoku[i][j] == n)
                    return false;
            }
        }

        // 행
        for(int j=0; j<9; j++){
            if(sudoku[row][j] == n)
                return false;
        }

        // 열
        for(int i=0; i<9; i++){
            if(sudoku[i][col] == n)
                return false;
        }

        return true;
    }

    private void solve(int index){
        Position pos = blankList.get(index);
        int row = pos.getRow();
        int col = pos.getCol();

        for(int n=1; n<=9; n++){

            // 대입이 가능하다면
            if(search(row, col, n)) {
                sudoku[row][col] = n;

                // 마지막 대입이 성공했다면 프로그램 종료
                if(index == blankList.size()-1){
                    endFlag = true;
                    return;
                }
                solve(index+1); // 다음 빈칸으로
                if(endFlag) return;
                sudoku[row][col] = 0; // 값도 반드시 다시 돌려놓기
            }
        }
    }

    private void run(){
        try{
            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<9; j++){
                    int num = Integer.parseInt(st.nextToken());
                    if(num==0){
                        blankList.add(new Position(i, j));
                    }
                    sudoku[i][j] = num;
                }
            }

            solve(0);

            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(sudoku[i][j] + " ");
                }
                sb.append("\n");
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