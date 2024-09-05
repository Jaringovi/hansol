package boj0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//45816 kb
// 440 ms
public class Boj줄세우기 {
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n, m;
	static int check[];
	static List<Integer> student[];
	static List<Integer> result;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		student = new ArrayList[n + 1];
		result = new ArrayList<>();
		check = new int[n + 1];
		for(int i=0; i<=n; i++){
			student[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			student[a].add(b);
			check[b]++; //진입차수
		}
		bfs();
		for(int r: result){
			output.append(r).append(" ");
		}
		System.out.print(output);
	}
	private static void bfs(){
		Queue<Integer> que = new ArrayDeque<>();
		for(int i=1; i<=n; i++){
			if(check[i] == 0) que.offer(i);
		}
		while(!que.isEmpty()){
			int x = que.poll();
			result.add(x);
			for(int s : student[x]){
				check[s]--;
				if(check[s]==0)	que.offer(s);
			}
		}
	}
}
