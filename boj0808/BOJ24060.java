package boj0808;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24060 {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static int arr[], temp[];
    private static int a, k, count;
    private static int res;

    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine());
        a = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        arr = new int[a];
        temp = new int[a];
        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        count = 0;
        res = -1;
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(res);
    }

    private static void merge_sort(int arr[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private static void merge(int arr[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= q) {
            temp[t++] = arr[i++];
        }
        while (j <= r) {
            temp[t++] = arr[j++];
        }

        t = 0;
        i = p;
        while (i <= r) {
            arr[i] = temp[t++];
            count++;
            if (count == k) {
                res = arr[i];
                break;
            }
            i++;
        }
    }
}
