package boj1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 20532 kb
// 228 ms
public class 나만안되는연애 {
    static int n, m;
    static char[] gender;
    static int[] parent;
    static Node[] roads;
    static StringTokenizer tokens;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());

        gender = new char[n];
        parent = new int[n];
        roads = new Node[m];

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            gender[i] = tokens.nextToken().charAt(0);
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken()) - 1;
            int b = Integer.parseInt(tokens.nextToken()) - 1;
            int c = Integer.parseInt(tokens.nextToken());
            roads[i] = new Node(a, b, c);
        }


        Arrays.sort(roads, (o1, o2) -> o1.d - o2.d);

        int cnt = 0;
        int ans = 0;

        for (Node road : roads) {
            int a = road.s;
            int b = road.e;
            int dist = road.d;


            if (gender[a] != gender[b] && union(a, b)) {
                ans += dist;
                cnt++;

                if (cnt == n - 1) break;
            }
        }

        if (cnt == n - 1) System.out.println(ans);
        else System.out.println("-1");
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}

class Node {
    int s, e, d;
    Node(int s, int e, int d) {
        this.s = s;
        this.e = e;
        this.d = d;
    }
}