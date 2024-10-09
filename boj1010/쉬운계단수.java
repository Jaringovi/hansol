package boj1010;

import java.io.*;
import java.util.*;

//17720	kb
// 172 ms
public class 쉬운계단수 {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(input.readLine());

        // i자리수 , 마지막 숫자가 j
        long[][] dp = new long[101][10];
        long mod = 1000000000;



        // 1자리 수일 때 1부터 9까지는 모두 계단 수
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 2자리 수부터 n자리 수까지
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                //마지막 숫자가 0이면 그 전에 나올 수 있는건 1
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                    //마지막 숫자가 9이면 그 전에 나올 수 있는 건 8
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % mod;
        }

        System.out.println(result);
    }
}

