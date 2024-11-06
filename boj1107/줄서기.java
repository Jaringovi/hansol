package boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 16632 kb
// 152 ms
public class 줄서기 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String arr[][];
    static int n;
    static Stack<String[]> stack;
    static List<String[]> enter;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(input.readLine());
        arr = new String[n * 5][2];
        stack = new Stack<>();
        enter = new ArrayList<>();

        for (int i = 0; i < n * 5; i += 5) {
            String str[] = input.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i + j][0] = str[j].split("-")[0];
                arr[i + j][1] = str[j].split("-")[1];
            }
        }

        boolean flag = true;
        for (int i = 0; i < n * 5; i++) {

            //대기 줄이 비어있으면 stack push
            if (stack.isEmpty()) {
                stack.push(new String[]{arr[i][0], arr[i][1]});
            } else {
                String c[] = stack.peek();

                // 지금 현재 앞에 있는게 스택 맨 앞보다 앞선것이면 stack push
                if (check(c, i)) {
                    stack.push(new String[]{arr[i][0], arr[i][1]});
                }
                //대기 줄에 있는게 더 앞선 경우 더 클때까지 pop
                else {
                    while (!stack.isEmpty()) {

                        String s[] = stack.peek();

                        if (!check(s, i)) {
                            enter.add(new String[]{s[0], s[1]}); // 입장
                            stack.pop();
                            if(!enterCheck(s)) flag = false;
                        } else break;
                    }
                    stack.push(new String[]{arr[i][0], arr[i][1]});
                }
            }
        }
        //스택에 남아있는거 확인
        while(!stack.isEmpty()) {
            String s[] = stack.pop();
            if(!enterCheck(s)) flag = false;
        }
        if(flag) System.out.println("GOOD");
        else System.out.println("BAD");


    }

    //앞서있는지 아닌지 체크
    static boolean check(String c[], int x) {
        return (arr[x][0].charAt(0) - c[0].charAt(0) < 0) || (arr[x][0].charAt(0) - c[0].charAt(0) == 0 &&
                Integer.parseInt(arr[x][1]) - Integer.parseInt(c[1]) < 0);
    }

    static boolean enterCheck(String s[]) {
        for (int i = 0; i < enter.size(); i++) {
            String c[] = enter.get(i);
            if (s[0].charAt(0) - c[0].charAt(0) < 0) return false;
            if (s[0].charAt(0) - c[0].charAt(0) == 0 &&
                    Integer.parseInt(s[1]) - Integer.parseInt(c[1]) < 0) return false;
        }
        return true;
    }
}
