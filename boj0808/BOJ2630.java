package boj0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static int n;
    private static int[][] map;
    private static int white, blue;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        divide(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int r, int c, int len) {
        if(check(r, c, len)){
            if(map[r][c] == 0){
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int divide_len = len/2;
        divide(r,c,divide_len);
        divide(r,c+divide_len,divide_len);
        divide(r+divide_len,c,divide_len);
        divide(r+divide_len,c+divide_len,divide_len);

    }

    //같은 색인지 확인
    private static boolean check(int r, int c, int len) {
        int current = map[r][c];
        for (int i = r; i < r+len; i++) {
            for (int j = c; j < c+len; j++) {
                if (map[i][j] != current) {
                    return false;
                }
            }
        }
        return true;
    }
}
