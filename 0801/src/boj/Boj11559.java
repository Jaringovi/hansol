package boj;

import java.io.*;
import java.util.*;

public class Boj11559 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static char map[][] = new char[12][6];
	private static int deltas[][] = {{0,-1},{1,0}, {-1,0}, {0,1}};
	private static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i=0; i<12; i++) {
			tokens = new StringTokenizer(input.readLine());
			String row = tokens.nextToken();
			for(int j=0; j<6; j++) {
				map[i][j]=row.charAt(j);
			}
		}
		
		int count=0; //최종 횟수
		
		while(true) {
			boolean flag = false; //뿌요가 있는지 확인
			visited = new boolean[12][6];
			for(int i=0; i<12; i++){
				for(int j=0; j<6; j++) {
					//문자가 있고 방문하지 않은 점이면 bfs 호출
					if(map[i][j]!='.' && !visited[i][j]) {
						if(bfs(i,j)) { //문자가 4개이상 연결되어있다면
							flag = true;
						}
					}
					
				}
			}
			//모든 점을 돌았는데 문자가 모두 . 이거나 bfs로 4개이상 없다면
			if(!flag) break;
			
			fall();
			count++;
			
		}
		System.out.println(count);
		
	}
		
	//4개이상 확인하는거
	static boolean bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> location = new LinkedList<>();
        
        char color = map[x][y];
        que.offer(new int[] {x, y});
        location.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int count = 0;
        
        while (!que.isEmpty()) {
            int[] t = que.poll();
            int dx = t[0];
            int dy = t[1];
            count++;
            
            for (int[] d : deltas) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                
                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && map[nx][ny] == color) {
                    que.offer(new int[] {nx, ny});
                    location.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        if (count >= 4) {
            while (!location.isEmpty()) {
                int[] p = location.poll();
                map[p[0]][p[1]] = '.';
            }
            return true;
        }
        
        return false;
    }
    
    static void fall() {
    	//아래서 위로 탐색
    	
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.') {
                	// .이 나오지 않을 때까지 반복
                	// 위로 올라가면서 뿌요가 있는지 탐색하는 거
                    int po = i;
                    while (po >= 0 && map[po][j] == '.') {
                        po--;
                    }
                    // 위로 올라가서 뿌요를 발견한 경우
                    if (po >= 0) {
                    	//맨 아래 위치에 뿌요를 넣어두고 뿌요가 있었던 곳에는 .을 채움
                        map[i][j] = map[po][j];
                        map[po][j] = '.';
                    }
                }
            }
        }
    }
}