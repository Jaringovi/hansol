package boj0905;
import java.io.*;
import java.util.*;
public class Boj테트로미노 {
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n, m, sum;
	static int map[][];

	// 모든 테트로미노 모양
	static int f[][][] = {
		//ㅡ형
		{{0, 1}, {0, 2}, {0, 3}}, {{1, 0}, {2, 0}, {3, 0}},
		//정사각형
		{{0, 1}, {1, 0}, {1, 1}},
		//L형
		{{1, 0}, {2, 0}, {2, 1}}, {{1, 0}, {0, 1}, {0, 2}},
		{{0, 1}, {1, 1}, {1, 2}}, {{0, 1}, {0, 2}, {-1, 2}},
		{{0, 1}, {0, 2}, {1, 1}}, {{0, 1}, {1, 0}, {2, 0}},
		{{0, 1}, {-1, 1}, {-2, 1}}, {{1, 0}, {1, 1}, {1, 2}},
		//ㄹ형
		{{0, 1}, {0, 2}, {-1, 1}}, {{1, 0}, {2, 0}, {1, 1}},
		{{0, 1}, {-1, 1}, {1, 1}}, {{1, 0}, {1, -1}, {1, 1}},
		//ㅜ형
		{{1, 0}, {1, 1}, {2, 1}}, {{0, 1}, {-1, 1}, {-1, 2}},
		{{1, 0}, {1, -1}, {2, -1}}, {{0, 1}, {1, 1}, {1, 2}}
	};

	public static void main(String[] args) throws IOException {
		sum = 0;
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		// 19개 확인
		for (int idx = 0; idx < f.length; idx++) {
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < m; col++) {
					int total = 0;
					boolean flag = true;

					//범위 내에 있는지 확인
					for (int i = 0; i < 3; i++) {
						int nx = row + f[idx][i][0];
						int ny = col + f[idx][i][1];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
							flag = false;
							break;
						}
					}

					// 범위 내에 있다면 계산
					if (flag) {
						total = map[row][col];
						for (int i = 0; i < 3; i++) {
							int nx = row + f[idx][i][0];
							int ny = col + f[idx][i][1];
							total += map[nx][ny];
						}
						sum = Math.max(total, sum);
					}
				}
			}
		}
		System.out.print(sum);
	}
}
