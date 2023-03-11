import java.io.PrintWriter;
import java.util.Scanner;

public class ExhaustiveSearch {
    public static int N;
    public static int[] A = new int[50];

    public static void main(String[] args) {
        int q, M;
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(sc.next());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sc.next());
        }
        q = Integer.parseInt(sc.next());
        for (int i = 0; i < q; i++) {
            M = Integer.parseInt(sc.next());
            if (solve(0, M)) {
                pw.println("yes");
            } else {
                pw.println("no");
            }
            pw.flush();
        }
        sc.close();
    }

    public static boolean solve(int i, int m) {
        if (m == 0) {
            return true;
        }
        if (i >= N) {
            return false;
        }
        boolean res = solve(i + 1, m) || solve(i + 1, m - A[i]);
        return res;
    }

}
