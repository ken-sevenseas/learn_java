import java.io.PrintWriter;
import java.util.Scanner;

public class Partition {
    public static int[] A;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int stn;
        N = Integer.parseInt(sc.next());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sc.next());
        }
        stn = partition(0, N - 1);
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                pw.print(" ");
            }
            if (i == stn) {
                pw.print("[");
            }
            pw.print(A[i]);
            if (i == stn) {
                pw.print("]");
            }
        }
        pw.println();
        pw.flush();
        sc.close();
    }

    public static int partition(int p, int r) {
        int x, i, temp;
        x = A[r];
        i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }
}
