import java.io.*;
import java.util.*;

// 14844 kb
// 136 ms

public class Boj주사위굴리기 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m,x,y,k;
    private static int map[][];
    private static int [] kArr, dice;
    public static void main(String[] args) throws IOException {
        dice = new int[6];
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        x = Integer.parseInt(tokens.nextToken());
        y = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        kArr = new int[k];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<k; i++){
            kArr[i] = Integer.parseInt(tokens.nextToken());
        }
        for(int c : kArr){
            rotate(c);
        }
    }

    //주사위
    //dice[0]윗면, dice[1]왼쪽, dice[2]바닥!!, dice[3]오른쪽 , dice[4]앞면, dice[5]뒷면
    private static void rotate(int command){
        boolean flag = false;
        int nx = x;
        int ny = y;
        switch(command){
            case 1: //동쪽
                if(ny+1 <m){
                    flag = true;
                    ny = ny+1;
                    //뒷면 앞면은 그대로
                    int temp = dice[0];
                    dice[0] = dice[1]; //왼쪽이 위로 올라옴
                    dice[1] = dice[2];
                    dice[2] = dice[3];
                    dice[3] = temp;
                }
                break;
            case 2: //서쪽으로
                if(ny-1>=0){
                    flag = true;
                    ny = ny-1;
                    int temp = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[2];
                    dice[2] = dice[1];
                    dice[1] = temp;
                }
                break;
            case 3: // 북쪽
                if(nx-1 >=0){
                    flag = true;
                    nx = nx-1;
                    int temp = dice[0];
                    dice[0]=dice[4];
                    dice[4]=dice[2];
                    dice[2]=dice[5];
                    dice[5]=temp;
                }
                break;
            case 4: //남쪽
                if(nx+1 < n){
                    flag = true;
                    nx = nx+1; //주사위 이동
                    int temp = dice[0];
                    dice[0]=dice[5];
                    dice[5]=dice[2];
                    dice[2]=dice[4];
                    dice[4]=temp;
                }
                break;
        }
        if(flag){
            x = nx;
            y = ny;
            if(map[nx][ny] == 0){ //칸이 0이라면
                map[nx][ny] = dice[2]; //바닥면에 있는 수가 복사
            }
            else{
                dice[2] = map[nx][ny]; //칸에 있는 수가 복사
                map[nx][ny] = 0;
            }
            System.out.println(dice[0]);
        }

    }
}

