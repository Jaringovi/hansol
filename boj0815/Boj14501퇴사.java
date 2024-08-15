package boj0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501퇴사 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            t[i] = Integer.parseInt(tokens.nextToken());
            p[i] = Integer.parseInt(tokens.nextToken());
        }
        //최대 수익 저장
        int[] dp = new int[n+1];

        //점화식
        for(int i=0; i<n; i++){
            if( i + t[i] <=n){ //상담 일수가 넘지 않을 때까지
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            //i반째 날까지 얻은 수익, 이미 i+1번째 날에 기록된 최대 수릭 중 큰거
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}
