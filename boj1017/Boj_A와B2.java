package boj1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_A와B2 {
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static String s,t;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		s = input.readLine();
		t = input.readLine();
		int len = t.length() - s.length();

		//길이가 같은데 문자가 다른 경우 바로 끝
		if(len == 0 && s.equals(t)) flag = true;
		dfs(t);
		if(flag) System.out.print(1);
		else System.out.print(0);

	}
	//문자 만들기
	static void dfs(String str) {
		//System.out.println(str);
		int len = str.length();
		if(len == s.length()) {
			if(check(str, s)) flag = true;
			return;
		}
		if(flag) return;
		//뒤에 글자 A일때 빼는 경우
		if(str.charAt(len-1) == 'A') dfs(str.substring(0,len-1));
		//맨 앞 B인경우 B제거 -> 뒤집
		if(str.charAt(0) == 'B') dfs(new StringBuilder(str.substring(1)).reverse().toString());
	}


	//문자열 비교
	static boolean check(String S, String T) {
		if(S.equals(T)) return true;
		return false;
	}
}
