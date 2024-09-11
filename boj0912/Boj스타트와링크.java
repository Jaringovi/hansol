package boj0912;

import java.io.*;
import java.util.*;

public class Boj스타트와링크 {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int [][] map;
    static boolean []visited;
    static int min_val = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int [n][n];
        visited = new boolean [n];
        for(int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        combi(0,0);
        System.out.println(min_val);
    }

    //조합으로 n/2 수 구하기
    static void combi(int start, int cnt) {
        if(cnt == n/2) {
            int s = getSum();
            min_val = Math.min(min_val, s);
            return;
        }
        for(int i = start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i+1, cnt+1);
                visited[i] = false;
            }
        }

    }

    //여기서 최대값 구하기
    static int getSum() {
        int startSum = 0;
        int linkSum = 0;
        List <Integer> start = new ArrayList<>();
        List <Integer> link = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                start.add(i);
            }
            else {
                link.add(i);
            }
        }
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                startSum += map[start.get(i)][start.get(j)];
                linkSum += map[link.get(i)][link.get(j)];
            }
        }
        return Math.abs(startSum-linkSum);
    }
}