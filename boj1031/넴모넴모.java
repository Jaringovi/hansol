package boj1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//17864 kb
//2328 ms


public class 넴모넴모 {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,ans;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        visited = new boolean[n][m];

        //부분집합
        subSet(0);
        System.out.println(ans);
    }
    //부분집합
    static void subSet(int cnt) {
        if(cnt == n*m) {
            //4개(2*2) 사각형이 있는지 파악
            //사각형이 이루어 지지 않도록, 터지지 않는거
            //0부터 n-2까지반복

            boolean flag=true;
            for(int i=0; i<=n-2; i++) {
                for(int j=0; j<=m-2; j++) {

                    if(check(i,j)) //터짐
                    {
                        flag = false ; // 터지는 경우
                    }
                }
            }
            if(flag) ans++;
            return;
        }

        visited[cnt/m][cnt%m] = true;
        subSet(cnt+1);
        visited[cnt/m][cnt%m] = false;
        subSet(cnt+1);
    }

    static boolean check(int x, int y) { //시작점
        //선택 된건 true
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                if(!visited[x+i][y+j]) return false;
            }
        }
        return true;
    }
}
