package boj0912;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj공유기설치 {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,c;
    static int []home;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        home = new int[n];
        for(int i=0; i<n; i++) {
            home[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(home);
        int start = 1;
        int end = home[n-1];
        int res=0;
        while(start <= end){
            int mid = (start + end ) /2; //거리
            int cnt =1;
            int preHome = home[0];

            for(int i=1; i<n; i++){
                if(home[i] - preHome >= mid){
                    //설치
                    cnt++;
                    preHome = home[i];
                }
            }
            if(c <= cnt){ //공유기 설치 완료 했는데 더 놓을 수 있는 경우, 최소 거리를 늘릴 수 있음
                res = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.print(res);
    }


}