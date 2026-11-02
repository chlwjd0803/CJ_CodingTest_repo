import java.io.*;
import java.util.*;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private int firmX;
	private int firmY;
	private int homeX;
	private int homeY;
	private int depth = 0;
	private int N;
	private int minDepth = Integer.MAX_VALUE;
	private int distance = 0;
	
	int[][] customers;
	boolean[] visited;
	
	
	private void dfs(int x, int y) {
		
		if(depth == N) {
			minDepth = Math.min(minDepth, distance 
					+ Math.abs(x - homeX) + Math.abs(y - homeY));
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(!visited[i]) {
				depth++;
				visited[i] = true;
				distance += Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]);
				dfs(customers[i][0], customers[i][1]);
				distance -= Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]);
				visited[i] = false;
				depth--;
			}
		}
		
		
	}
	
	private void attempt() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		firmX = Integer.parseInt(st.nextToken());
		firmY = Integer.parseInt(st.nextToken());
		homeX = Integer.parseInt(st.nextToken());
		homeY = Integer.parseInt(st.nextToken());
		
		customers = new int[N][2];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			customers[i][0] = Integer.parseInt(st.nextToken());
			customers[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(firmX, firmY);
		
		sb.append(minDepth + "\n");
	}
	
	
	public static void main(String args[]) throws Exception
	{
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#" + test_case + " ");
			new Solution().attempt();
		}
		System.out.print(sb.toString());
	}
}