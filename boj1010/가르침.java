package boj1010;
import java.io.*;
import java.util.*;

//15552 kb
// 300 ms
public class 가르침{
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    static boolean visited[];
    static String strArr[];
    static int maxVal = 0;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        strArr = new String[n];

        // a,n,t,i,c는 무조건 포함
        // K가 5 미만이면 읽을 수 있는 단어는 없음
        if (k < 5) {
            System.out.println(0);
            return;
        }

        visited = new boolean[26]; // 알파벳 체크
        // a,n,t,i,c 제거
        for (int i = 0; i < n; i++) {
            String str = input.readLine();
            strArr[i] = str.substring(4, str.length() - 4);
        }

        //a, n, t, i, c는 선택
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        combi(0, 0);
        System.out.print(maxVal);
    }

    static void combi(int start, int cnt) {
        if (cnt == k - 5) {
            int c = check();
            maxVal = Math.max(c, maxVal);
            return;
        }
        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    // 현재 선택된 문자로 읽을 수 있는지 체크
    static int check() {
        int count = 0;
        for (String s : strArr) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if (!visited[s.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }
}
