import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	int[][] grid;
	int N = 100;
	
	private boolean validPos(int x) {
		return (x>=0) && (x<N);
	}
	
	public void attempt() throws Exception {
		grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			
			if(grid[0][i] == 1) {
				int x = i;
				for(int y=0; y<N; y++) {
					
//					System.out.print("(x,y) (" + x + "," + y + ") ");
					
					if(grid[y][x] == 2) {
						sb.append(i);
						return;
					}
					
					// 한쪽으로 갔으면 되돌아오지 않기 위함
					boolean notCrossed = true;
					
					while(validPos(x-1) && grid[y][x-1]==1) {
						x--;
						notCrossed = false;
					}
					
					while(validPos(x+1) && grid[y][x+1]==1 && notCrossed) {
						x++;
					}
				}
			}
		}
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
