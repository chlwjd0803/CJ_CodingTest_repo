import java.io.*;
import java.util.*;


public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	boolean[][] grid;
	
	
	void attempt() throws IOException {
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		grid = new boolean[256][N];
		
		st = new StringTokenizer(br.readLine());
		for(int c=0; c<N; c++) {
			int layer = Integer.parseInt(st.nextToken());
			
			for(int r=0; r<layer; r++) {
				grid[r][c] = true;
			}
		}
		
		
		for(int c=2; c<N-2; c++) {
			
			for(int r=0; r<256 && grid[r][c]; r++) {
				
				if(!grid[r][c-1] && !grid[r][c-2] && !grid[r][c+1] && !grid[r][c+2])
					count++;
			}
		}
		
		sb.append(count + "\n");
	}
	
	
	public static void main(String args[]) throws Exception
	{

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			sb.append("#" + test_case + " ");
			new Solution().attempt();

		}
		System.out.print(sb.toString());
	}
	
	
}