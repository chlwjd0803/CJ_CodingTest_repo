import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	StringBuilder tsb;
	
	int[][] grid;
	int N = 4;
	
	int[][] direction = new int[][] {
		{-1,0}, {1,0}, {0,-1}, {0,1}
	};
	
	HashSet<String> hs;
	
	
	private boolean validMove(int row, int col) {
		return (row>=0) && (row<N) && (col>=0) && (col<4);
	}
	
	private void dfs(int row, int col, int len) {
	
		
		if(len==7) {
			hs.add(tsb.toString());
			return;
		}
		
		
		for(int[] d : direction) {
			if(validMove(row+d[0], col+d[1])) {
				tsb.append(grid[row+d[0]][col+d[1]]);
				dfs(row+d[0], col+d[1], len+1);
				tsb.deleteCharAt(tsb.length() - 1);
			}
		}
	}
	
	public void attempt() throws Exception {
		hs = new HashSet<>();
		grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		tsb = new StringBuilder();
		
		for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
			tsb.append(grid[i][j]);
			dfs(i, j, 1);
			tsb.deleteCharAt(tsb.length() - 1);
		}
		
		sb.append(hs.size());
	}
	
	public static void main(String args[]) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			sb.append("#" + test_case + " ");
			new Solution().attempt();
			sb.append("\n");

		}
		
		System.out.print(sb.toString());
	}
}
