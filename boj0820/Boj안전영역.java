package boj0820;

import java.io.*;
import java.util.*;

public class Boj안전영역 {
    private static StringTokenizer tokens;
    private static boolean visited[][];
    private static int deltas[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int n;
    private static int map[][];
    private static int min_val=Integer.MAX_VALUE, max_val=Integer.MIN_VALUE;
    private static int res=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int [n][n];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
                min_val = Math.min(min_val, map[i][j]);
                max_val = Math.max(max_val, map[i][j]);
            }
        }
        //System.out.println(min_val + " " + max_val);

        //최소값부터 최대값까지 안전영역이 최대가 되는 수
        for(int m = min_val-1; m<=max_val; m++) { //주의
            int temp[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                temp[i] = map[i].clone();
            }
            //새로운 배열에 복사
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(temp[i][j] <= m){ //물에 잠김
                        temp[i][j] =0;
                    }
                }
            }

            //이제 bfs로 temp에서 0이 아닌 안전영역 구함
            visited = new boolean[n][n];
            int count=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(temp[i][j] != 0 && !visited[i][j]){
                        bfs(i,j,temp);
                        count++;
                    }
                }
            }
            //System.out.println(count + " " + m);
            //현재랑 최대개수 비교
            res = Math.max(res, count);
        }
        System.out.println(res);
    }

    //bfs로 0이 아닌값
    private static void bfs(int x, int y, int temp[][]){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!que.isEmpty()){
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int d[]: deltas){
                int nx = dx+d[0];
                int ny = dy+d[1];
                if(nx>=0 && nx<n && ny>=0 &&ny<n){
                    if(!visited[nx][ny] && temp[nx][ny]!=0){
                        que.offer(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
