package boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 15220 kb
// 168 ms
public class 미친로봇 {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static double[] per;
    static boolean visited[][];
    static int deltas[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}}; //동서북남
    static double ans;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        per = new double[4];
        visited = new boolean[30][30];
        for(int i=0; i<4; i++) {
            per[i] = Integer.parseInt(tokens.nextToken()) * 0.01;
        }
        visited[15][15] = true;
        dfs(0,1,15,15);
        System.out.print(ans);
    }

    static void dfs(int cnt, double res, int x, int y) {
        if(cnt == n) {
            ans += res;
            return;
        }
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x+deltas[i][0];
            int ny = y+deltas[i][1];
            if(check(nx,ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(cnt+1, res*per[i], nx, ny);
                visited[nx][ny] = false;
            }

        }
    }
    static boolean check(int x, int y) {
        return x>=0 && x<30 && y>=0 && y<30;
    }
}
