package boj0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 14048kb
// 100ms

public class Boj도영이가만든맛있는음식 {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int food[][];
    static boolean visited[];
    static int min_val = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        food = new int [n][2];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            food[i][0] = Integer.parseInt(tokens.nextToken());
            food[i][1] = Integer.parseInt(tokens.nextToken());
        }
        subSet(0);
        System.out.print(min_val);
    }
    private static void subSet(int cnt){
        if(cnt==n) {
            boolean flag = false;
            int aSum=1, bSum=0;
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    flag = true;
                    aSum*=food[i][0];
                    bSum+=food[i][1];
                }
            }
            if(flag) min_val = Math.min(Math.abs(aSum-bSum), min_val);
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1);
        visited[cnt] = false;
        subSet(cnt+1);
    }
}