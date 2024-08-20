// 17144 KB
// 108 ms

import java.io.*;
import java.util.*;

public class Boj연산자끼워넣기 {
    private static StringBuilder output = new StringBuilder();
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] sign = new int[4];
    private static int arr[];
    private static int max_val = Integer.MIN_VALUE;
    private static int min_val = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        n =Integer.parseInt(input.readLine());
        arr = new int[n];
        tokens = new StringTokenizer(input.readLine());
        //피연산자 넣기
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(input.readLine());
        //연산자 넣기
        for(int i=0; i<4; i++){
            sign[i] = Integer.parseInt(tokens.nextToken());
        }
        dfs(1,arr[0]);
        System.out.println(max_val);
        System.out.print(min_val);
    }

     //재귀와 백트래킹으로 모든 연산자 순서 구하기
    private static void dfs(int cnt, int sum){
        if(cnt==n){
            min_val = Math.min(min_val, sum);
            max_val = Math.max(max_val, sum);
            return;
        }
        if(sign[0] > 0 ){ //+연산자가 1개 이상이라면
            sign[0]--;
            dfs(cnt+1, sum+arr[cnt]);
            sign[0]++;
        }
        if(sign[1] > 0 ){ //-연산자가 1개 이상이라면
            sign[1]--;
            dfs(cnt+1, sum-arr[cnt]);
            sign[1]++;
        }
        if(sign[2] > 0 ){ //*연산자가 1개 이상이라면
            sign[2]--;
            dfs(cnt+1, sum*arr[cnt]);
            sign[2]++;
        }
        if(sign[3] > 0 ){ //나누기 연산자가 1개 이상이라면
            sign[3]--;
            dfs(cnt+1, sum/arr[cnt]);
            sign[3]++;
        }
    }
}
