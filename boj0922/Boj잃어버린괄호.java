package boj0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14372	kb
//104 ms
public class Boj잃어버린괄호 {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine(), "-");
        int sum = 0;
        int cnt = 0;
        while(tokens.hasMoreTokens()) {
            StringTokenizer plusTokens = new StringTokenizer(tokens.nextToken(), "+");
            int sub = 0;


            //덧셈 더하기
            while(plusTokens.hasMoreTokens()) {
                sub += Integer.parseInt(plusTokens.nextToken());
            }

            if(cnt == 0) {
                sum +=sub;
                cnt+=1;
            }
            else {
                sum -=sub;
            }
        }
        System.out.println(sum);
    }

}
