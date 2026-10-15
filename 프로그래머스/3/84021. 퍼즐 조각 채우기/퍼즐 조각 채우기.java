import java.io.*;
import java.util.*;

public class Solution {

    // 행렬 사이즈
    private int N;

    HashMap<Integer, List<int[][]>> blanks;
    HashMap<Integer, List<int[][]>> blocks;

    // 상하좌우
    private int[][] direction = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    private boolean validMove(int row, int col){
        return (row>=0) && (row<N) && (col>=0) && (col<N);
    }

    private void insert(HashMap<Integer, List<int[][]>> map, int[][] arr){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(arr[i][j] == 1){
                    // {행, 열}
                    Queue<int[]> q = new LinkedList<>();

                    // 지나간 좌표를 기억하는 배열 {행, 열}
                    List<int[]> mem = new ArrayList<>();

                    q.offer(new int[] {i, j});
                    arr[i][j] = 0; // 얘를 visited 처럼 이용
                    int size = 1; // 한번이라도 걸리면 일단 사이즈 1

                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        mem.add(temp);

                        for(int[] dir : direction){
                            // 해당방향으로 이동 가능하며 1이라면
                            if(validMove(temp[0]+dir[0], temp[1]+dir[1])
                                    && (arr[temp[0]+dir[0]][temp[1]+dir[1]] == 1)){
                                q.offer(new int[] {temp[0]+dir[0], temp[1]+dir[1]});
                                arr[temp[0]+dir[0]][temp[1]+dir[1]] = 0;
                                size++;
                            }
                        }
                    }

                    // 저장한 모든 좌표에 대해 최소행과 최소열 찾기
                    int minRow = Integer.MAX_VALUE;
                    int minCol = Integer.MAX_VALUE;
                    for(int[] pos : mem){
                        if(minRow > pos[0])
                            minRow = pos[0];
                        if(minCol > pos[1])
                            minCol = pos[1];
                    }

                    // 좌표 저장
                    int[][] save = new int[6][6];
                    for(int k=0; k<6; k++) for(int l=0; l<6; l++)
                        save[k][l] = 0;
                    // 즉시 정규화 (당겨 저장)
                    for(int[] pos : mem){
                        save[pos[0]-minRow][pos[1]-minCol] = 1;
                    }

                    // 초기화가 안되어있다면 초기화해주기
                    if(!map.containsKey(size))
                        map.put(size, new ArrayList<>());

                    // 해당 사이즈에 해당되는 리스트에 배열을 추가
                    List<int[][]> list = map.get(size);
                    list.add(save);
                }
            }
        }
    }

    private int[][] normalization(int[][] arr){
        int[][] temp = new int[6][6];

        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                temp[i][j] = 0; // 초기화하면서

                // 최소행과 최소열 찾기
                if(arr[i][j] == 1){
                    if(minRow > i)
                        minRow = i;
                    if(minCol > j)
                        minCol = j;
                }
            }
        }

        for(int i=0; i<6; i++) for(int j=0; j<6; j++){
            if(arr[i][j] == 1)
                temp[i-minRow][j-minCol] = 1;
        }

        return temp;
    }

    private int[][] rotation(int[][] arr){
        int[][] temp = new int[6][6];

        for(int i=0; i<6; i++) for(int j=0; j<6; j++){
            temp[i][j] = 0;
        }

        for(int i=0; i<6; i++) for(int j=0; j<6; j++){
            if(arr[i][j] == 1){
                // 90도 회전
                temp[j][5-i] = 1;
            }
        }

        // 한바퀴 돌린것을 왼쪽 상단으로 이동
        return normalization(temp);
    }

    private boolean isSame(int[][] blank, int[][] block){
        boolean result = false;

        // 회전을 위한 반복문, 총 4번 돌아서 원위치로 오게됨
        for(int ro=0; ro<4; ro++){
            boolean flag = true;
            for(int i=0; i<6 && flag; i++) for(int j=0; j<6; j++){
                if (blank[i][j] != block[i][j]) {
                    flag = false; // 불일치 하는게 하나라도 발견되면 탈출해야함
                    break;
                }
            }
            result |= flag; // 하나라도 성립하는게 있었다면 true일것
            block = rotation(block);
        }

        return result;
    }

    public int solution(int[][] game_board, int[][] table) {
        int count = 0;

        N = game_board.length;
        blanks = new HashMap<>();
        blocks = new HashMap<>();

        // 해시맵에 각 빈칸들과 블록 투입, 게임 보드만 0,1 뒤집어서 이용
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++)
            game_board[i][j] = 1 - game_board[i][j];
        insert(blanks, game_board);
        insert(blocks, table);

        for(int size : blanks.keySet()){

            // 해당 사이즈에 해당하는 모든 블록들을 가져오기
            List<int[][]> blo = blocks.getOrDefault(size, new ArrayList<>());
            // 같은 것임을 알아두기
//            List<int[][]> blo = blocks.get(size);
//            if (blo == null) {
//                blo = new ArrayList<>();
//            }

            for(int[][] bnk : blanks.get(size)){
                for(int i=0; i<blo.size(); i++){
                    if(isSame(bnk, blo.get(i))){
                        count += size;
                        blo.remove(i);
                        break;
                    }
                }
            }
        }
        return count;
    }
}