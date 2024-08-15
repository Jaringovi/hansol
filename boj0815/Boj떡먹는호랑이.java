package boj0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj떡먹는호랑이 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        int d = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 30; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int a = 1;
        int b;
        // 피보나치 수열을 일반화 해보면
        // k = dp[d-3] * A + dp[d-2] * B 이다.
        while (true) {
            if ((k - dp[d - 3] * a) % dp[d - 2] == 0) {
                b = (k - dp[d - 3] * a) / dp[d - 2];
                break;
            }
            a++;
        }

        System.out.println(a);
        System.out.println(b);
    }
}
