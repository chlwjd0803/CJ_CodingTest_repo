import java.io.*;
import java.util.*;


public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	int[][] maze;
	boolean[][] visited;
	int N = 16;
	
	int[][] direction = new int[][] {
		{-1,0}, {1,0}, {0,-1}, {0,1}
	}; // 상하좌우
	
	int startRow;
	int startCol;
	int endRow;
	int endCol;
	
	
	public void attempt() throws Exception {
		maze = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			
			for(int j=0; j<N; j++) {
				maze[i][j] = (int) row.charAt(j) - '0';
				
				if(maze[i][j] == 2) {
					startRow = i;
					startCol = j;
				}
				
				if(maze[i][j] == 3) {
					endRow = i;
					endCol = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startRow, startCol});
		visited[startRow][startCol] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int curRow = temp[0];
			int curCol = temp[1];
			
			if(maze[curRow][curCol] == 3) {
				sb.append("1");
				return;
			}
			
			for(int[] d : direction) {
				if(!visited[curRow+d[0]][curCol+d[1]] && maze[curRow+d[0]][curCol+d[1]] != 1) {
					q.offer(new int[] {curRow+d[0], curCol+d[1]});
					visited[curRow+d[0]][curCol+d[1]] = true;
				}
			}
			
			
		}
		sb.append("0");
		
	}
	
	
	public static void main(String args[]) throws Exception {

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			sb.append("#" + br.readLine() + " ");
			new Solution().attempt();
			sb.append("\n");

		}
		
		System.out.print(sb.toString());
	}
}
