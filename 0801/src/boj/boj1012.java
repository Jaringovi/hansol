package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class boj1012 {

	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output= new StringBuilder();
	private static StringTokenizer  tokens;
	
	private static int m,n,k;
	private static int deltas [][] = { {1,0}, {-1,0}, {0,-1}, {0,1} };
	private static int map[][];
	private static Queue<int[]> que = new LinkedList <>();
	
	private static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int t = Integer.parseInt(input.readLine());
		for(int s=0; s<t; s++) {
			count=0;
			tokens = new StringTokenizer(input.readLine());
			m=Integer.parseInt(tokens.nextToken());
			n=Integer.parseInt(tokens.nextToken());
			k=Integer.parseInt(tokens.nextToken());
			map = new int[n][m];
			
			
			for(int i=0; i<k; i++) { //	입력받고 map 채우기
				tokens = new StringTokenizer(input.readLine());
				int y=Integer.parseInt(tokens.nextToken());
				int x=Integer.parseInt(tokens.nextToken());
				for(int r=0; r<n; r++) {
					for(int c=0; c<m; c++ ) {
						if(r==x && c==y) {
							map[r][c]=1;
						}
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==1) {
						bfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

		
	}
	
	private static void bfs(int x, int y) {
		que.add(new int[] {x,y});
		
//		visited[x][y]=true;
		map[x][y]=0; //방문처리
		while(!que.isEmpty()) {
			int t[]=que.poll();
			int dx =t[0];
			int dy =t[1];
			for(int d=0; d<4; d++) {
				int nx = dx+deltas[d][0];
				int ny = dy+deltas[d][1];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==1) {
						que.add(new int[] {nx,ny});
						map[nx][ny]=0;
					}
				}
			}
		}
	}
}