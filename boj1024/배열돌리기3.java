package boj1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 528 ms
// 메모리 70016 kb

public class 배열돌리기3 {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,r;
    static int d[];
    static int[][] map;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m= Integer.parseInt(tokens.nextToken());
        r= Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        d = new int[r];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<r; i++) {
            d[i] = Integer.parseInt(tokens.nextToken());
        }

        for(int rInx: d) {
            if(rInx==1){
                one();
            } else if (rInx==2) {
                two();
            } else if (rInx==3) {
                three();
            } else if (rInx==4) {
                four();

            } else if (rInx==5) {
                five();

            }else {
                six();
            }
        }

        for(int i=0; i<map.length; i++ ) {
            for(int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }


    }
    static void one() { //상하반전
        int r = map.length;
        int c = map[0].length;
        int newMap[][] = new int[r][c];
        for(int i=0; i<r; i++) {
            newMap[i] = map[r-i-1].clone();
        }
        map = newMap;
    }

    static void two() { //좌우반전
        int r = map.length;
        int c = map[0].length;
        int newMap[][] = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                newMap[i][j] = map[i][c-j-1];
            }
        }
        map = newMap;
    }
    static void three() { //오른쪽 90도
        int r = map.length;
        int c = map[0].length;
        int newMap[][] = new int[c][r];
        for(int i=0; i<c; i++ ) {
            for(int j=0; j<r; j++) {
                newMap[i][j] = map[r-j-1][i];
            }
        }
        map = newMap;
    }

    static void four() { //왼쪽 90도
        int r = map.length;
        int c = map[0].length;
        int newMap[][] = new int[c][r];
        for(int i=0; i<c; i++ ) {
            for(int j=0; j<r; j++) {
                newMap[i][j] = map[j][c-1-i];
            }
        }
        map = newMap;
    }

    static void five() {
        int r = map.length;
        int c = map[0].length;
        int newMap[][] = new int[r][c];
        int x = r/2;
        int y = c/2;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                newMap[i][j + y] = map[i][j];         // 1 -> 2
                newMap[i + x][j + y] = map[i][j + y]; // 2 -> 3
                newMap[i + x][j] = map[i + x][j + y]; // 3 -> 4
                newMap[i][j] = map[i + x][j];         // 4 -> 1
            }
        }
        map = newMap;
    }
    static void six() {
        int r = map.length;
        int c = map[0].length;
        int newMap[][] = new int[r][c];

        int x = r / 2;
        int y = c / 2;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                newMap[i + x][j] = map[i][j];         // 1 -> 4
                newMap[i + x][j + y] = map[i + x][j]; // 4 -> 3
                newMap[i][j + y] = map[i + x][j + y]; // 3 -> 2
                newMap[i][j] = map[i][j + y];         // 2 -> 1
            }
        }
        map = newMap;
    }
}