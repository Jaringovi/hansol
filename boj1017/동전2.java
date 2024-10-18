package boj1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 동전2 {
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n,k;
	public static void main(String[] args) throws IOException {

		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(input.readLine());
		k = Integer.parseInt(input.readLine());
		int arr[] = new int[n+1];
		int dp[] = new int [k+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		for(int i=0; i<n; i++) {
			for(int j=dp[i]; j<=k; j++) {
				arr[j] = Math.min(arr[j], arr[j-arr[i]]+1);
			}
		}
		if(arr[k] == Integer.MAX_VALUE-1) System.out.println(-1);
		else System.out.println(arr[k]);
	}


}
