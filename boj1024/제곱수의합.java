package boj1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 4844 ms
// 메모리 14636 kb

public class 제곱수의합 {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int [] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i/2; j++) {
                if(j*j == i) {
                    dp[i] = 1;
                }
                dp[i] = Math.min(dp[i],dp[j]+dp[i-j]);

            }
        }
        System.out.println(dp[n]);


    }
}