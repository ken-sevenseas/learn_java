import java.io.PrintWriter;
import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(sc.next());
        int[] F = new int[N + 1];

        F[0] = F[1] = 1;
        for (int i = 2; i <= N; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        pw.println(F[N]);
        pw.flush();
        sc.close();
    }
}
