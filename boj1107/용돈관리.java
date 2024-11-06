package boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 22432kb
// 216ms
public class 용돈관리 {
    static StringTokenizer tokens;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int [] arr;
    static int n,m;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        arr = new int[n];
        int sum =0;
        int start = 0;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
            sum+=arr[i];
            start = Math.max(start, arr[i]);
        }

        int end = sum;

        int ans = end; //m을 만족하는

        while(start <=end) {
            int mid = (start+end)/2;
            int cnt =1; //현재 인출한 돈 횟수
            int money = mid; //인출하고 남은 돈
            for(int i=0; i<n; i++) {
                if(arr[i] > money){
                    cnt++;
                    money = mid ;//다시 인출
                }
                money -= arr[i];
            }
            System.out.println(mid);
            //인출한 횟수가 m보다 많으면 안됨
            //범위를 더 크게 해야함
            if(cnt > m) {
                start = mid+1;
            }
            else{
                end = mid-1;
                ans = mid;
            }
        }
        System.out.println(ans);

    }
}
