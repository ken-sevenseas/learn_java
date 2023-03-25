import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciNumber2 {
    //    static int[] dp;
    static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(sc.next());
        for (int i = 0; i < N + 1; i++) {
            dp.add(-1);
        }
//        dp = new int[N + 1];

        pw.println(fibonacci(N));
        pw.flush();
        sc.close();
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            dp.set(n, 1);
            return dp.get(n);
        }
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
