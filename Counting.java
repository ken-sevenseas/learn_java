import java.io.PrintWriter;
import java.util.Scanner;

public class Counting {
    static int N;
    static int[] A, B;
    static int[] cnt = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(sc.next());
        A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            A[i + 1] = Integer.parseInt(sc.next());
            cnt[A[i + 1]]++;
        }
        sort(A);
        for (int i = 1; i <= N; i++) {
            if (i > 1) {
                pw.print(" ");
            }
            pw.print(B[i]);
        }
        pw.println();
        pw.flush();
        sc.close();
    }

    public static void sort(int[] A) {
        B = new int[N + 1];
        for (int i = 1; i <= 10000; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }
        for (int i = 1; i <= N; i++) {
            B[cnt[A[i]]] = A[i];
            cnt[A[i]]--;
        }
    }
}
