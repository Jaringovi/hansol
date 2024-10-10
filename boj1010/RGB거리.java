import java.io.*;
import java.util.*;

// 14520 kb
// 112 ms

public class RGB거리 {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int map[][];
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(input.readLine());
		map = new int[n][3];

		for(int i = 0; i < n; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		//n이 빨이라면 n-1은 초 아니면 파 중에 작은거
		for(int i=1; i<n; i++) {
			map[i][0] = Math.min(map[i-1][1], map[i-1][2]) + map[i][0];
			map[i][1] = Math.min(map[i-1][0], map[i-1][2]) + map[i][1];
			map[i][2] = Math.min(map[i-1][0], map[i-1][1]) + map[i][2];
		}
		int result = Math.min(map[n-1][0], Math.min(map[n-1][1], map[n-1][2]));
		System.out.print(result);
	}
}
