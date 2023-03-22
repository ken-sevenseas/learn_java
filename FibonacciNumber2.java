import java.io.PrintWriter;
import java.util.Scanner;

public class FibonacciNumber2 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(sc.next());
        dp = new int[N + 1];

        pw.println(fibonacci(N));
        pw.flush();
        sc.close();
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
