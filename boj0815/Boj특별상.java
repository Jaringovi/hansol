package boj0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj특별상 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static int c[][];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());
        c = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                c[i][j] = Integer.parseInt(tokens.nextToken());
            }
            System.out.println(divide(n, 0, 0));
        }
    }
    //분할 정복
    private static int divide(int size, int row, int col) {
        // 종료 조건: 1x1 크기
        if (size == 1) {
            return c[row][col];
        } else {
            // 2차원 배열을 4등분하여 각 구역의 두 번째로 작은 값을 찾기
            int[] sub = new int[]{
                    //좌상단
                    divide(size / 2, row, col),
                    //우상단
                    divide(size / 2, row, col + size / 2),
                    //좌하단
                    divide(size / 2, row + size / 2, col),
                    //우하단
                    divide(size / 2, row + size / 2, col + size / 2)
            };
            //정렬
            Arrays.sort(sub);
            // 두 번째로 작은 값을 반환
            return sub[1];
        }
    }
}