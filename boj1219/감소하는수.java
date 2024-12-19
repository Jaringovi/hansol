package boj1219;

import java.io.*;
import java.util.*;

// 112 ms
// 15512 kb
public class 감소하는수 {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static ArrayList<Long> number = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(input.readLine());

		// 감소하는 수 생성
		for (int length = 1; length <= 10; length++) { // 1부터 10까지
			permutation(9, length, 0, new int[length]);
		}

		// 정렬
		Collections.sort(number);

		if (n >= number.size()) {
			System.out.println(-1);
		} else {
			System.out.println(number.get(n));
		}
	}

	static void permutation(int start, int length, int depth, int[] result) {
		if (depth == length) {
			long num = 0;
			for (int i = 0; i < length; i++) {
				num = num * 10 + result[i];
			}
			number.add(num);
			return;
		}

		for (int i = start; i >= 0; i--) { // 숫자를 큰 숫자부터
			result[depth] = i;
			permutation(i - 1, length, depth + 1, result);
		}
	}
}
