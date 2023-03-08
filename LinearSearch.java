import java.io.PrintWriter;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        int N = Integer.parseInt(sc.next());
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        int M = Integer.parseInt(sc.next());
        for (int i = 0; i < M; i++) {
            if (search(arr, N, Integer.parseInt(sc.next()))) {
                sum++;
            }
        }
        sc.close();
        pw.println(sum);
        pw.flush();
    }

    public static boolean search(int[] arr, int n, int key) {
        int i = 0;
        arr[n] = key;
        while (arr[i] != key) {
            i++;
        }
        return i != n;
    }
}
