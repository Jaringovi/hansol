package boj;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Boj7562 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static StringBuilder output = new StringBuilder();
	private static int map [][];
	private static int deltas[][] = {{-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {1,2},{2,1}};
	
	private static int t,l,x,y,dx,dy;
	private static int min_value = Integer.MAX_VALUE;
	private static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		t =Integer.parseInt(input.readLine());
		for(int tc=0; tc<t; tc++) {
			l = Integer.parseInt(input.readLine()); 
			map = new int[l][l];
			visited = new boolean [l][l];
			tokens = new StringTokenizer(input.readLine());
			x =Integer.parseInt(tokens.nextToken());
			y =Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(input.readLine());
			dx =Integer.parseInt(tokens.nextToken());
			dy =Integer.parseInt(tokens.nextToken());
			min_value=bfs(x,y,0);
			output.append(min_value).append('\n');
		}
		System.out.println(output);
	}
	private static int bfs(int x, int y, int cnt) {
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{x, y, 0}); //현재 위치랑 cnt를 배열로 넣어놓기
		
		
		while(!que.isEmpty()) { 
			int locate[]=que.poll();
			x = locate[0];
			y = locate[1];
			cnt = locate[2];
			
			if(x==dx && y==dy) { //중단 기준은 만날 때
				return cnt;
			}
			
			for(int[] d: deltas) {
				int nx = x+d[0];
				int ny = y+d[1];
				if(nx>=0 && nx<l && ny>=0 && ny<l) {
					if(map[nx][ny]==0) {
						que.offer(new int[] {nx,ny, cnt+1});
						map[nx][ny]=1;
					}
				}
			}
		}
		
		return -1;
	}
}

