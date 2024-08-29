package boj0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15632 kb
//176 ms
public class Boj부분수열의합 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static StringBuilder output = new StringBuilder();
	private static int n,s, res;
	private static int arr[];
	private static boolean visited[];
	public static void main(String[] args) throws IOException {

		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		s = Integer.parseInt(tokens.nextToken());
		arr = new int [n];
		visited = new boolean[n];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		subSet(0);
		System.out.print(res);
	}

	//부분집합 사용
	private static void subSet(int cnt){
		if(cnt == n){
			if (sum()) res++;
			return;
		}
		visited[cnt] = true;
		subSet(cnt+1);
		visited[cnt] = false;
		subSet(cnt+1);
	}

	private static boolean sum (){
		//공집합인 경우 제외
		int total=0;
		boolean flag = false;
		for(int i=0; i<n; i++){
			if(visited[i]) {
				total+=arr[i];
				flag = true;
			}
		}
		if(total==s && flag) return true;
		return false;
	}
}